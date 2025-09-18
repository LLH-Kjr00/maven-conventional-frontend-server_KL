package com.cmt.vending.server.operation;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.cmt.vending.util.DateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cmt.vending.server.job.UploadVmRequestLogJob;
import com.cmt.vending.ws.obj.xsd.VmRequestLogInfo;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpProgressMonitor;

/**
 * Util to handle the download of media and firmware upgrade package
 */
public class SFTPComm {

    private static final Logger logger = LogManager.getLogger(SFTPComm.class);

    public static String SFTP_HOST = "svm.365vending.net";
    public static String SFTP_USERNAME = "vendingcmt";
    public static String SFTP_PW = "CMTech@2019*";
    public static String SFTP_PORT = "22";
    public static String SFTP_DOWNLOAD_PATH = "/opt/vending-cmt/media";
    public static String SFTP_UPLOAD_PATH = "";

    public static void printSftpInfo() {
        logger.info("SFTP_HOST: " + SFTP_HOST);
        logger.info("SFTP_PORT: " + SFTP_PORT);
        logger.info("SFTP_USERNAME: " + SFTP_USERNAME);
        logger.info("SFTP_PW: " + SFTP_PW);
        logger.info("SFTP_DOWNLOAD_PATH: " + SFTP_DOWNLOAD_PATH);
    }

    private static class SFTPConstants {
        public static final String SFTP_REQ_HOST = "host";
        public static final String SFTP_REQ_PORT = "port";
        public static final String SFTP_REQ_USERNAME = "username";
        public static final String SFTP_REQ_PASSWORD = "password";
        public static final int SFTP_DEFAULT_PORT = 22;
    }

    private static class SFTPChannel {
        Session session = null;
        Channel channel = null;

        public ChannelSftp getChannel(Map<String, String> sftpDetails, int timeout) throws JSchException {

            String ftpHost = sftpDetails.get(SFTPConstants.SFTP_REQ_HOST);
            String port = sftpDetails.get(SFTPConstants.SFTP_REQ_PORT);
            String ftpUserName = sftpDetails.get(SFTPConstants.SFTP_REQ_USERNAME);
            String ftpPassword = sftpDetails.get(SFTPConstants.SFTP_REQ_PASSWORD);

            int ftpPort = SFTPConstants.SFTP_DEFAULT_PORT;
            if (port != null && !port.equals("")) {
                ftpPort = Integer.valueOf(port);
            }

            JSch jsch = new JSch();
            session = jsch.getSession(ftpUserName, ftpHost, ftpPort);

            if (ftpPassword != null) {
                session.setPassword(ftpPassword);
            }

            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.setTimeout(timeout);
            session.connect();

            channel = session.openChannel("sftp");
            channel.connect();
            return (ChannelSftp) channel;
        }

        public void closeChannel() throws Exception {
            if (channel != null) {
                channel.disconnect();
            }
            if (session != null) {
                session.disconnect();
            }
        }
    }

    private static class  FileProgressMonitor implements SftpProgressMonitor {

        private static final Logger logger = LogManager.getLogger("schedule");

        private long transfered;

        @Override
        public boolean count(long count) {
            transfered = transfered + count;
            return true;
        }

        @Override
        public void end() {
            logger.info("Transferring Completed At " + DateUtil.formatDateTime(new Date(), true));
        }

        @Override
        public void init(int op, String src, String dest, long max) {
            logger.info("Transferring Start At " + DateUtil.formatDateTime(new Date(), true));
        }
    }



    public static boolean download(String targetFileName, String distLocation, boolean isAdv) {
        return download(targetFileName, distLocation, targetFileName, isAdv);
    }

    /**
     * Download file by SFTP (pre-requisite -> the file is not downloaded yet; if it is downloaded, return false)
     * @param targetFileName : Filename on back end server
     * @param distLocation
     * @param fileName : Filename of the file to be saved
     * @param isAdv
     * @return
     */
    public static boolean download(String targetFileName, String distLocation, String fileName, boolean isAdv) {
        boolean res = false;

        // Check if the destination folder exist
        File folder = new File(distLocation);
        if(!folder.exists()) {
            logger.info("[download]Folder [ " + folder.getAbsolutePath() + " ] is not exist, create folder now.");
            folder.mkdirs();
        }

        // Check if the file is downloaded or not
        File f = new File(distLocation + "/" + fileName + "_finished");
        File tf = new File(distLocation + "/" + fileName);
        if(f.exists() && tf.length() > 0) {
            return false;
        }

        Map<String, String> sftpDetails = new HashMap<String, String>();
        sftpDetails.put(SFTPConstants.SFTP_REQ_HOST, SFTP_HOST);
        sftpDetails.put(SFTPConstants.SFTP_REQ_PORT, SFTP_PORT);
        sftpDetails.put(SFTPConstants.SFTP_REQ_USERNAME, SFTP_USERNAME);
        sftpDetails.put(SFTPConstants.SFTP_REQ_PASSWORD, SFTP_PW);

        SFTPChannel channel = new SFTPChannel();
        ChannelSftp chSftp = null;
        try {
            chSftp = channel.getChannel(sftpDetails, 3000);

            String filename = SFTP_DOWNLOAD_PATH + "/" + targetFileName;
            logger.info("[download]Start to download file from SFTP server: " + filename);

            long filesize = chSftp.stat(filename).getSize();
            chSftp.get(filename, distLocation + "/" + fileName, new FileProgressMonitor(), ChannelSftp.RESUME);

            File downf = new File(distLocation + "/" + fileName);
            if(downf.length() == filesize) {
                res = true;
                logger.info("[download]Download file from server successfully.");
            }else {
                logger.info("[download]File from server is not completed");
            }

        } catch (Exception e) {
            logger.error("[download]Failed to download file [ " + targetFileName + " ] from SFTP Server", e);
        } finally {
            try {
                if(chSftp != null) {
                    chSftp.quit();
                }
                channel.closeChannel();
            } catch (Exception e) {
                logger.error("[download]Failed to close SFTP Channel", e);
            }
        }

        if(res) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                logger.error("[download]Failed to create Finished File", e);
            }
        }

        if (!isAdv) {
            try {
                VmRequestLogInfo info = new VmRequestLogInfo();
                info.setRequestType(7);
                info.setStatus(res? "S": "F");
                info.setRemark("Media Id:" + targetFileName);
                UploadVmRequestLogJob.getVmRequestLogHistory().getHistory().add(info);
            }
            catch(Exception e) {
                logger.error("[download]Failed to add request log.", e);
            }
        }


        return res;
    }

}
