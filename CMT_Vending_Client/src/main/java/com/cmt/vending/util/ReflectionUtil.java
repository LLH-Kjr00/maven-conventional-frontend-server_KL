package com.cmt.vending.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReflectionUtil {
	private static Logger logger = LogManager.getLogger(ReflectionUtil.class);
	
	private static final BeanUtilsBean BeanUtil = new BeanUtilsBean();
	static {
		IntegerConverter converter = new IntegerConverter(null);
		DateConverter dateConverter = new DateConverter(null);
		BigDecimalConverter bigDecimalConverter = new BigDecimalConverter(null);
		
		BeanUtil.getConvertUtils().register(converter, Integer.class);
		BeanUtil.getConvertUtils().register(dateConverter, Date.class);
		BeanUtil.getConvertUtils().register(bigDecimalConverter, BigDecimal.class);
	}
	
	public static Object createInstance(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		return createInstance(className, "com.cmt.util.query");
	}
	
	public static Object createInstance(String className, String defaultPackage) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String name = className.indexOf('.') == -1 ? (defaultPackage + "." +className) : className;
		return Class.forName(name).newInstance();
	}
	
	 public static void copyProperties(Object dest, Object orig) throws IllegalAccessException, InvocationTargetException {
		 BeanUtil.copyProperties(dest, orig);
	 }
	 
	 
	public static void main(String[] args) {
		String name = "name";
		System.out.println(name + "=" + getFieldName(name) + "*");
		
		name = "callInDttm";
		System.out.println(name + "=" + getFieldName(name) + "*");
		
		name = "nFrom";
		System.out.println(name + "=" + getFieldName(name) + "*");
		
		name = "tpCallbackTime1";
		System.out.println(name + "=" + getFieldName(name) + "*");
		
		name = "svWeekCountingOpt";
		System.out.println(name + "=" + getFieldName(name) + "*");
	} 
	 
	public static String getFieldName(String field) {
		try {
			StringBuffer sb = new StringBuffer(String.valueOf(field.charAt(0)).toUpperCase());
			int lastUpperCase = 1;
			for(int i = 1; i < field.length(); i ++) {
				char c = field.charAt(i);
				if(Character.isLetter(c) && Character.isUpperCase(c)) {
					if(lastUpperCase > 1) {
						sb.append(" ");
					}
					sb.append(field.substring(lastUpperCase, i));
					lastUpperCase = i;
				}
			}
			if(lastUpperCase < field.length() - 1) {
				if(lastUpperCase > 1) {
					sb.append(" ");
				}
				sb.append(field.substring(lastUpperCase));
			}
			
			return sb.toString();
		} catch(Exception e) {
			logger.debug("Failed to convert name.", e);
			return field;
		}
	}
	 
	public static String[] getHeaderArray(Map<String, PropertyDescriptor> propMap) {
		String[] headers = new String[propMap.size()];
		
		int i = 0;
		for(String prop : propMap.keySet()) {
			headers[i++] = StringUtil.getCsvText(getFieldName(prop));
		}
		
		return headers;
	}
	 
	public static Map<String, PropertyDescriptor> getPropMap(Object bean) throws IntrospectionException {
		Map<String, PropertyDescriptor> propMap = new LinkedHashMap<String, PropertyDescriptor>();

		if (bean != null) {
			Field[] fields = bean.getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				propMap.put(fields[i].getName(), null);
			}

			BeanInfo info = Introspector.getBeanInfo(bean.getClass());
			PropertyDescriptor[] pds = info.getPropertyDescriptors();
			for (PropertyDescriptor pd : pds) {
				if (propMap.containsKey(pd.getName())) {
					propMap.put(pd.getName(), pd);
				}
			}
		}
		
		//ignore some fields
		propMap.remove("logger");

		return propMap;
	}
	 
	 public static String[] beanToStringArray(Object bean, Map<String, PropertyDescriptor> propMap, boolean dateOnly, boolean withSec) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		 String[] vals = new String[propMap.size()];
		 
		 int i = 0;
		 PropertyDescriptor pd = null;
		 for(String prop : propMap.keySet()) {
			 pd = propMap.get(prop);
			 Object val = pd.getReadMethod().invoke(bean, null);
			 if(val == null) {
				 vals[i] = StringUtil.getCsvText("");
			 }
			 else {
				 if(val instanceof Date) {
					 if(dateOnly) {
						 vals[i] = StringUtil.getCsvText(DateUtil.formatDate((Date) val));
					 }
					 else {
						 vals[i] = StringUtil.getCsvText(DateUtil.formatDateTime((Date) val, withSec));
					 }
				 }
				 else {
					 vals[i] = StringUtil.getCsvText(String.valueOf(val));
				 }
			 }
			 i ++;
		 }
		 
		 return vals;
	 }
}
