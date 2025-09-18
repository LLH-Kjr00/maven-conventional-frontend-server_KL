package com.cmt.vending.server.job;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cmt.vending.server.operation.BackendServerComm;
import com.cmt.vending.server.operation.ResourceManager;
import com.cmt.vending.server.operation.LocalDataManager;
import com.cmt.vending.ws.GetServiceStub;
import com.cmt.vending.ws.GetVmGroupId;
import com.cmt.vending.ws.GetVmGroupIdResponse;
import com.cmt.vending.ws.obj.xsd.GetVmGroupIdReq;
import com.cmt.vending.ws.obj.xsd.GetVmGroupIdResp;

public class GetGroupIdJob implements Runnable{
	
	private static final Logger logger = LogManager.getLogger(GetGroupIdJob.class);

	@Override
	public void run(){
		logger.info("[GetGroupIdJob-run] Start get groupd ID.");
		getGroupId();

	}
	
	private void getGroupId() {
		try {
			GetServiceStub stub = BackendServerComm.getGetServiceStub();
			GetVmGroupId req = new GetVmGroupId();
			GetVmGroupIdReq reqObj = new GetVmGroupIdReq();
			req.setReq(reqObj);

			BackendServerComm.setGeneralInfo(reqObj);
			
			try {
				GetVmGroupIdResponse resp = stub.getVmGroupId(req);
				GetVmGroupIdResp respObj = resp.get_return();
				
				HeartbeatJob.updateSucessTimeMsToServer();
				
				if (respObj.getResult()) {
					logger.info("[getGroupId]Get group Id successfully : " + respObj.getGroupId());
					
					LocalDataManager.getGroupInfo().setGroupId(respObj.getGroupId());
					ResourceManager.saveInfo(LocalDataManager.getGroupInfo(), ResourceManager.INFO_GROUP_CONF);

				} else {
					logger.error("[getGroupId]Failed to get group ID: [" + respObj.getErrorCode() + "] "
							+ respObj.getErrorMsg());
				}
			} catch (Throwable e) {		
				logger.error("[getGroupId]Failed to get group ID: ", e);
			}
		} catch(Exception e) {
			logger.error("[getGroupId]Failed to init comm with server: " , e);
		}
		
	}

}
