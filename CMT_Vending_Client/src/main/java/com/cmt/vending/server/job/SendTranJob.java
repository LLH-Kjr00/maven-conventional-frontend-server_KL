package com.cmt.vending.server.job;

import java.util.concurrent.Callable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.cmt.vending.util.ReflectionUtil;
import com.cmt.vending.server.operation.BackendServerComm;
import com.cmt.vending.util.ModemUtil;
import com.cmt.vending.server.operation.TransactionManager;
import com.cmt.vending.ws.SendTran;
import com.cmt.vending.ws.SendTranResponse;
import com.cmt.vending.ws.VendingStub;
import com.cmt.vending.ws.obj.xsd.TranInfo;
import com.cmt.vending.ws.obj.xsd.SendTranReq;
import com.cmt.vending.ws.obj.xsd.SendTranResp;

public class SendTranJob implements Callable<Boolean>, Job{

	private static Logger logger = LogManager.getLogger("schedule");
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		BackendServerComm.startJob(this);
	}

	@Override
	public Boolean call() throws Exception {
		logger.info("[SendTranJob-call]Start to upload transaction info to server.");
		boolean res = false;
		
		if(TransactionManager.getTranHistory().getTran().size() == 0) {
			logger.info("[SendTranJob-call]Trasaction list is empty, Ignore current job.");
			return true;
		} else {
			int numOfTran = TransactionManager.getTranHistory().getTran().size();
			logger.info("[SendTranJob-call]Num of transaction waiting to upload: " + numOfTran);
		}
		
		TranInfo[] array = new TranInfo[TransactionManager.getTranHistory().getTran().size()];
		for(int i=0; i< array.length; i++) {
			TranInfo tran = new TranInfo();
			ReflectionUtil.copyProperties(tran, TransactionManager.getTranHistory().getTran().get(i));
			array[i] = tran;
		}
		if(array == null || array.length == 0) {
			logger.info("[SendTranJob-call]Transaction list is empty, Ignore current job.");
			return true;
		}
		
		try {
			VendingStub stub = BackendServerComm.getVendingStub();
			SendTran req = new SendTran();
			SendTranReq reqObj = new SendTranReq();
			req.setReq(reqObj);
			
			BackendServerComm.setGeneralInfo(reqObj);
			reqObj.setTrans(array);
			
			try {
				SendTranResponse resp = stub.sendTran(req);
				SendTranResp respObj = resp.get_return();
				
				HeartbeatJob.updateSucessTimeMsToServer();
				
				if(respObj.getResult()) {
					logger.info("[SendTranJob-call]Upload Transaction Info Successfully.");
					return true;
				}
				else {
					logger.error("[SendTranJob-call]Failed to upload transaction info to server : [" + respObj.getErrorCode() + "] " + respObj.getErrorMsg());
				}
				
			} catch (Exception e) {
				logger.error("[SendTranJob-call]Failed to upload transaction info to server.");
			}
			
			if(BackendServerComm.IS_WIRELESS_NETWORK){
				logger.info("[SendTranJob-call]Try to reconnect mobile network.");
				ModemUtil.reconnect();
			}
			
		} catch (Exception e) {
			logger.error("[SendTranJob-call]Failed to init comm with server: " , e);
		}
		return res;
	}

}
