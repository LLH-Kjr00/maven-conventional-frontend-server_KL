package com.cmt.vending.util;

import java.io.BufferedReader;
import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GsonUtil {
	private static final Logger logger = LogManager.getLogger(GsonUtil.class);
	
	private static final boolean DEV_FLAG = true;
	private static final Gson GSON_DF = createBuilder(DateUtil.DATE_FORMAT).create();
	private static final Gson GSON_DTF = createBuilder(DateUtil.DATETIME_FORMAT).create();
	private static final Gson GSON_DTF_NON_SEC = createBuilder(DateUtil.DATETIME_FORMAT_NON_SEC).create();
	
	private static GsonBuilder createBuilder(String datetimeFormat) {
		GsonBuilder gb = new GsonBuilder().setDateFormat(datetimeFormat);
		//gb.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		//gb.registerTypeHierarchyAdapter(HibernateProxy.class, new HibernateProxySerializer());
		
		gb.registerTypeAdapter(Integer.class, new TypeAdapter<Integer>() {
	        @Override
	        public Integer read(JsonReader reader) throws IOException {
	            if (reader.peek() == JsonToken.NULL) {
	                reader.nextNull();
	                return null;
	            }
	            String stringValue = reader.nextString();
	            try {
	            	Integer value = Integer.valueOf(stringValue);
	                return value;
	            } catch (NumberFormatException e) {
	                return null;
	            }
	        }

	        @Override
	        public void write(JsonWriter writer, Integer value) throws IOException {
	            if (value == null) {
	                writer.nullValue();
	                return;
	            }
	            writer.value(value);
	        }
	    });
		
		if(DEV_FLAG) {
			gb.setPrettyPrinting();
		}
		return gb;
	}
	
	public static String toJson(Object src) {
		return toJson(src, true);
	}
	
	public static String toJson(Object src, boolean withSecondDateFormat) {
		return toJson(src, false, withSecondDateFormat);
	}
	
	public static String toJson(Object src, boolean dateOnly, boolean withSecondDateFormat) {
		if(dateOnly) {
			return GSON_DF.toJson(src);
		}
		else {
			if(withSecondDateFormat) {
				return GSON_DTF.toJson(src);
			}
			else {
				return GSON_DTF_NON_SEC.toJson(src);
			}
		}
	}
	
	public static String toJsonDateOnly(Object src) {
		return GSON_DF.toJson(src);
	}
	
	public static <T> T populateFromRequest(HttpServletRequest request, Class<T> classOfT) throws IOException {
		//possible values are: DO:Date only, DT:Datetime, DTNS:Datetime without second
		String dateTimeFormat = request.getParameter("dtf");
		logger.debug("dtf:" + dateTimeFormat);
		
		Gson gson = GSON_DF;
		if("DT".equals(dateTimeFormat)) {
			gson = GSON_DTF;
		}
		else if("DTNS".equals(dateTimeFormat)) {
			gson = GSON_DTF_NON_SEC;
		}
		
		BufferedReader reader = request.getReader();
		return gson.fromJson(reader, classOfT);	
	}
	
	public static <T> T populateFromString(String jsonString, Class<T> classOfT) throws IOException {
		Gson gson = GSON_DTF;
		return gson.fromJson(jsonString, classOfT);	
	}
}
