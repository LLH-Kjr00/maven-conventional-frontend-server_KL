package com.cmt.octopus;

/**
 * @author CMT
 * Copyright (c) 2016 Clever Motion Technology.
 * All rights reserved. 
 * Powered by Clever Motion Technology Limited
 */
public class RwlCons {
	public static final int RETURN_SUCCESSFUL_CODE = 0;
	// for XFile
	public static final int WARNING_OBTAIN_AR = 90001;
	public static final int WARNING_WRIT_AR = 90002;
	public static final int WARNING_WRITE_RWLI_VER = 90003;
	public static final int WARNING_SIGN = 90004;
	public static final int WARNING_END_OF_FILE = 90005;
	public static final int WARNING_FILE_HEADER = 90006;
	public static final int WARNING_UD_BLK_HEADER = 90007;
	public static final int WARNING_PURGE_UD = 90008;
	
	public static final int ERR_RW_NOT_CONNECTED = 100001;
	public static final int ERR_INVALID_PARAMETERS = 100003;
	public static final int ERR_INVALID_RESPONSE = 100005;
	public static final int ERR_CARD_READ_ERROR = 100016;
	public static final int ERR_CARD_WRITE_ERROR = 100017;
	public static final int ERR_CARD_BLOCKED = 100019;
	public static final int ERR_CARD_NOT_POLLED = 100020; //Card has not been polled before or no card present
	public static final int ERR_LAST_ADD_VALUE_GREATER_THAN_1000_DAYS = 100021;
	public static final int ERR_MUST_RETRY = 100022; // Note: A 100022(Retry please) occurs when the customer pull out the card too quickly. The R/W is not sure if the data is successfully written to the card or not. Hence, the R/W returns with this error code to advise the customer to present the card again. The R/W will correctly handle the different cases of retry; the same transaction will not be deducted twice. Refer to Volume A1 on Unconfirmed Transaction Handling.
	public static final int ERR_TRANSACTION_LOG_FULL = 100023;
	public static final int ERR_CARD_BLOCKED_BY_THIS_CALL = 100024; //Card is blocked by this call. In this case, PollData contains the UD.
	public static final int ERR_NO_CARD_PRESENT = 100032;
	public static final int ERR_CARD_AUTH = 100034; //Card authentication error
	public static final int ERR_CARD_RECOVER = 100035;
	public static final int ERR_INSUFFUCUENT_FUND = 100048;
	public static final int ERR_SYSTEM_TIME = 100066;
	public static final int ERR_FAILED_CREATE_ARFail_create_AR = 100101;
	public static final int ERR_FAILED_CREATE_UD = 100102;
	public static final int FIRMWARE_UPGRADE_PERFORMED = 100099;
	
}
