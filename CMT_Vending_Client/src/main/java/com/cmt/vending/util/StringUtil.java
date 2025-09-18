package com.cmt.vending.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringUtil {
	private static Logger logger = LogManager.getLogger(StringUtil.class);
	private static final String DIGIT_PATTERN = "\\d+";
	
	public static String stringMD5(String input) {
		  try {
		     // 拿到一個MD5轉換器（如果想要SHA1引數換成”SHA1”）
		     MessageDigest messageDigest =MessageDigest.getInstance("MD5");
		     // 輸入的字串轉換成位元組陣列
		     byte[] inputByteArray = input.getBytes();
		     // inputByteArray是輸入字串轉換得到的位元組陣列
		     messageDigest.update(inputByteArray);
		     // 轉換並返回結果，也是位元組陣列，包含16個元素
		     byte[] resultByteArray = messageDigest.digest();
		     // 字元陣列轉換成字串返回
		     return byteArrayToHex(resultByteArray);
		  } catch (NoSuchAlgorithmException e) {
		     return null;
		  }
		}
	//下面這個函式用於將位元組陣列換成成16進位制的字串
	public static String byteArrayToHex(byte[] byteArray) {
	  // 首先初始化一個字元陣列，用來存放每個16進位制字元
	  char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'A','B','C','D','E','F' };
	  // new一個字元陣列，這個就是用來組成結果字串的（解釋一下：一個byte是八位二進位制，也就是2位十六進位制字元（2的8次方等於16的2次方））
	  char[] resultCharArray =new char[byteArray.length * 2];
	  // 遍歷位元組陣列，通過位運算（位運算效率高），轉換成字元放到字元陣列中去
	  int index = 0;
	  for (byte b : byteArray) {
	     resultCharArray[index++] = hexDigits[b>>> 4 & 0xf];
	     resultCharArray[index++] = hexDigits[b& 0xf];
	  }
	  // 字元陣列組合成字串返回
	  return new String(resultCharArray);
	}
	public static boolean isDigits(String text) {
		return text.matches(DIGIT_PATTERN);
	}
	
	public static boolean isEmpty(String text){
		return text == null || "".equals(text.trim());
	}
	
	public static boolean isValidHH24MM(String val) {
		return isValidHH24MM(val, false);
	}
	
	public static boolean isValidHH24MM(String val, boolean withHourSeparator) {
		if(isEmpty(val)) {
			return false;
		}
		
		val = val.trim();
		
		if(withHourSeparator && (val.length() != 5 || val.charAt(2) != ':')) {
			return false;
		}
		
		if(!withHourSeparator && val.length() != 4) {
			return false;
		}
		
		int h = getIntVal(val.substring(0, 2));
		int m = withHourSeparator ? getIntVal(val.substring(3, 5)) : getIntVal(val.substring(2, 4));
		if(h > 24 || m >= 60) {
			return false;
		}
		
		return true;
	}
	
	public static int getIntVal(String strVal) {
		if(isEmpty(strVal)) {
			return 0;
		}
		
		strVal = strVal.trim();
		if(strVal.startsWith("0")) {
			strVal = strVal.substring(1);
		}
		
		try {
			return Integer.parseInt(strVal);
		} catch (Exception e) {
			return 0;
		}
	}
	
	public static boolean isInt(String strVal) {
		try {
			Integer.parseInt(strVal);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isLong(String strVal) {
		try {
			Long.parseLong(strVal);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isDouble(String strVal) {
		try {
			Double.parseDouble(strVal);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isFloat(String strVal) {
		try {
			Float.parseFloat(strVal);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
		
	public static String format(String pattern, String param) {
		return format(pattern, new String[]{param});
	}
	
	public static String format(String pattern, String[] params) {
		if(params == null) {
			return pattern;
		}
		
		try {
			for(int i = 0; i < params.length; i ++) {
				pattern = pattern.replaceAll("%" + (i + 1), params[i]);
				pattern = pattern.replaceAll("％" + (i + 1), params[i]);				
			}
		} catch (Exception e) {
			logger.error("Failed to format:" + pattern, e);			
		}
		
		return pattern;
	}
	
	public static String nullToEmpty(String str) {
		return str == null ? "" : str;
	}
	
	public static List<String> stringToList(String text){
		return stringToList(text, ",");
	}
	
	public static List<String> stringToList(String text, String separator){
		List<String> list = new ArrayList<String>();
		
		if(!isEmpty(text)) {
			String[] tmp = text.split(separator);
			for(int i = 0; i < tmp.length; i ++) {
				list.add(tmp[i].trim());
			}
		}
		
		return list;
	}
	
	public static String listToString(List<String> list) {
		return listToString(list, ",");
	}
	
	public static String listToString(List<String> list, String separator) {
		if(list.size() == 0) {
			return "";
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < list.size(); i ++) {
			if(i > 0) {
				sb.append(separator);
			}
			sb.append(list.get(i));
		}
		
		return sb.toString();
	}
	
	public static String withBom(String text) {
		return '\ufeff' + text;
	}
	
	public static String getCsvText(String text) {
		if(text == null) {
			return "";
		}
		
		return text.replaceAll("\n", " ");
	}
	
	public static void main(String[] args) {
		String intVal = "000123";
		System.out.println(intVal +  " is int:" + isInt(intVal));
		intVal = "123";
		System.out.println(intVal +  " is int:" + isInt(intVal));
		intVal = "12.1";
		System.out.println(intVal +  " is int:" + isInt(intVal));
		
		String text = "0123456789";
		System.out.println("*" + text + "* is digits only:" + isDigits(text));
		text = "123 456";
		System.out.println("*" + text + "* is digits only:" + isDigits(text));
		text = "";
		System.out.println("*" + text + "* is digits only:" + isDigits(text));
		text = "123456a";
		System.out.println("*" + text + "* is digits only:" + isDigits(text));
		text = "123456 ";
		System.out.println("*" + text + "* is digits only:" + isDigits(text));
		text = " 123456";
		System.out.println("*" + text + "* is digits only:" + isDigits(text));
		text = "123456.0";
		System.out.println("*" + text + "* is digits only:" + isDigits(text));
		
		String[] params = {"S101"};
		System.out.println(format("The site \"%1\" saved successfully.", params));
		System.out.println(format("場地“％1”已成功儲存。", params));
		
		String[] params2 = {"S101%2", "xxx"};
		System.out.println(format("The site \"%1\" saved %1 successfully  %2.", params2));
		System.out.println(format("場地“％1”已成 ％1 功儲存 ％2。", params2));
	}
}
