package com.cmt.vending.server.vmc.jy;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.BitSet;

public class CommandSet {
	
	// public static final byte[] CMD_CEHCK_RELAY_STATUS = { (byte) 0xFE, 0x01, 0x00, 0x00, 0x00, 0x10, 0x29, (byte) 0xC9 }; 			//	查詢繼電器狀態
	
	public static final byte[] CMD_CHECK_OPTOCOUPLER_STATUS = { (byte) 0xFE, 0x02, 0x00, 0x00, 0x00, 0x10, 0x6D, (byte) 0xC9 };		// 	查詢光耦器狀態

	public static final int RELAY_BASE_NO = 3;																						//	不要問只要信
	
	public static byte[] CMD_FLASH_ON_RELAY(int itemNo, int time) {
		byte[] relayNo = ByteBuffer.allocate(4).putInt(RELAY_BASE_NO + (5 * (itemNo - 1))).array();
		
		return generateCommand(new byte[] { (byte) 0xFE, 0x10, relayNo[2], relayNo[3], 0x00, 0x02, 0x04, 0x00, 0x04, 0x00, (byte) time});
	}
	
	private static byte[] generateCommand(byte[] data) {
		byte[] command = new byte[2 + data.length];
		for (int i = 0; i < data.length; i++) {
			command[i] = data[i];
		}

		byte[] checkSum = getCRC(data);
		command[data.length] = checkSum[0];
	    command[data.length + 1] = checkSum[1];

		return command;
	}
	
	public static byte[] getCRC(byte[] data) {
        byte[] buf = new byte[data.length];										
        for (int i = 0; i < data.length; i++) {
            buf[i] = data[i];
        }
        int len = buf.length;
        int crc = 0xFFFF;														//16位
        for (int pos = 0; pos < len; pos++) {
            if (buf[pos] < 0) {
                crc ^= (int) buf[pos] + 256; 									// XOR byte into least sig. byte of
                // crc
            } else {
                crc ^= (int) buf[pos]; 											// XOR byte into least sig. byte of crc
            }
            for (int i = 8; i != 0; i--) { 										// Loop over each bit
                if ((crc & 0x0001) != 0) { 										// If the LSB is set
                    crc >>= 1; 													// Shift right and XOR 0xA001
                    crc ^= 0xA001;
                } else
                    // Else LSB is not set
                    crc >>= 1; // Just shift right
            }
        }
        
        byte[] bytes = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(crc).array();
        return new byte[]{ bytes[0], bytes[1] };
    }
	
	public static BitSet byteArray2BitSet(byte[] bytes) {  
        BitSet bitSet = new BitSet(bytes.length * 8);  
        int index = 0;  
        for (int i = 0; i < bytes.length; i++) {  
            for (int j = 7; j >= 0; j--) {  
                bitSet.set(index++, (bytes[i] & (1 << j)) >> j == 1 ? true  : false);  
            }  
        }  
        return bitSet;  
    } 
	
	public static int convertIndex(int itemNo) {
		return itemNo <= 8 ? ( 8 - itemNo ) : ( 24 - itemNo );
	}
}
