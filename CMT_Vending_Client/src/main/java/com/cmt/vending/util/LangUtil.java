package com.cmt.vending.util;

import java.util.Locale;
import java.util.ResourceBundle;

import jakarta.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LangUtil {
	private static final Logger logger = LogManager.getLogger(LangUtil.class);

	public static String RES_BUNDLE = "com.cmt.vending.ui.i18n.Label";
	public static final String DEFAULT_LANG = "zh";
	
	
	public static String getI18nMsg(HttpServletRequest request, String msgEng, String msgChi) {
		return getI18nMsg(getLocale(request), msgEng, msgChi);
	}
	
	public static String getI18nMsg(Locale locale, String msgEng, String msgChi) {
		return "en".equals(locale.getLanguage()) ? msgEng : msgChi;
	}
	
	public static String getI18nMsg(String msgCode, HttpServletRequest request) {
		return getI18nMsg(msgCode, getLocale(request));
	}
	
	public static ResourceBundle getResourceBundle(HttpServletRequest req) {
		return getResourceBundle(getLocale(req));
	}
	
	public static ResourceBundle getResourceBundle(Locale locale) {
		return ResourceBundle.getBundle(RES_BUNDLE, locale);
	}
		
	public static String getI18nMsg(String msgCode, Locale locale) {
		if(StringUtil.isEmpty(msgCode)) {
			return "";
		}
		
		try {
			ResourceBundle rb = getResourceBundle(locale);
			return rb.getString(msgCode);
		} catch (Exception e) {
			logger.error("[getI18nMsg]Error", e);
			return msgCode;
		}		
	}
	
	public static Locale getLocale(HttpServletRequest request) {
		Locale loc = (Locale)request.getSession().getAttribute("javax.servlet.jsp.jstl.fmt.locale.session");
		logger.info("LOCALE"+ loc);
		if(loc == null) {
			loc = new Locale(DEFAULT_LANG);
			setLocale(request, loc);
		}
		
		return loc;
	}
	
	public static void setLocale(HttpServletRequest request, Locale loc) {
		request.getSession().setAttribute("javax.servlet.jsp.jstl.fmt.locale.session", loc);
	}
	
	public static String getEasyUiLang(HttpServletRequest req) {
		//use parameter
		String lang = req.getParameter("lang");
		if(!"en".equals(lang) && !"zh".equals(lang)) {
			lang = null;
		}
		
		//use session parameter
		if(StringUtil.isEmpty(lang)) {
			Locale loc = (Locale)req.getSession().getAttribute("javax.servlet.jsp.jstl.fmt.locale.session");
			if(loc != null) {
				lang = loc.getLanguage();
			}
		}
		
		//user header
		if(StringUtil.isEmpty(lang)) {
			lang = req.getHeader("accept-language");
			if(!StringUtil.isEmpty(lang)) {
				lang = lang.toLowerCase();
				if(lang.startsWith("en")) {
					lang = "en";
				}
				else if(lang.startsWith("zh")) {
					lang = "zh";
				}
				else {
					lang = null;
				}
			}			
		}
		
		if(StringUtil.isEmpty(lang)) {
			lang = DEFAULT_LANG;
		}
		
		setLocale(req, new Locale(lang));
		
		
		return "<script type=\"text/javascript\" src=\"" + req.getContextPath() + "/js/locale/easyui-lang-" + lang + ".js\"></script>";
	}
}
