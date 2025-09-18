package com.cmt.vending.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class DateUtil {
    public static String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static String DATETIME_FORMAT_NON_SEC = "yyyy-MM-dd HH:mm";
    public static String DATE_FORMAT = "yyyy-MM-dd";
    public static String PWD_FORMAT = "yyMMdd";
    public static String MTH_FORMAT = "yyyyMM";
    public static String DATE_FORMAT_SHORT = "yyyyMMdd";
    public static String TIME_FORMAT_SHORT = "HH:mm";

    private static final DateFormat DT_FORMAT = new SimpleDateFormat(DATETIME_FORMAT);
    private static final DateFormat DT_NON_SEC_FORMAT = new SimpleDateFormat(DATETIME_FORMAT_NON_SEC);
    private static final DateFormat D_FORMAT = new SimpleDateFormat(DATE_FORMAT);
    private static final DateFormat D_PWD_FORMAT = new SimpleDateFormat(PWD_FORMAT);
    private static final DateFormat M_FORMAT = new SimpleDateFormat(MTH_FORMAT);
    private static final DateFormat D_FORMAT_SHORT = new SimpleDateFormat(DATE_FORMAT_SHORT);
    private static final DateFormat T_FORMAT_SHORT = new SimpleDateFormat(TIME_FORMAT_SHORT);

    //private static final String[] DAY_LABEL = {"sun", "mon", "tue", "wed", "thu", "fri", "sat"};

	/*public static final String getDayDesc(Date date, Locale loc) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return LangUtil.getI18nMsg(DAY_LABEL[cal.get(Calendar.DAY_OF_WEEK) - 1], loc);
	}*/

    public static Date getDateTimeWithoutSec(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    public static Date getCurrentDateTime(boolean withSecond) {
        Calendar cal = Calendar.getInstance();

        //ignore ms in mysql
        cal.set(Calendar.MILLISECOND, 0);

        if(!withSecond) {
            cal.set(Calendar.SECOND, 0);
        }

        return cal.getTime();
    }

    public static Date getCurrentDateTime() {
        return getCurrentDateTime(true);
    }

    public static void setDateOnly(Calendar cal) {
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
    }

    public static Date getCurrentDate() {
        Calendar cal = Calendar.getInstance();
        setDateOnly(cal);
        return cal.getTime();
    }

    public static String getCurrentDateStr() {
        return formatDate(getCurrentDate());
    }

    public static String getCurrentDateTimeStr() {
        return formatDateTime(getCurrentDateTime(), true);
    }

    public static String formatDate(Date date) {
        if(date == null) {
            return "";
        }

        return D_FORMAT.format(date);
    }

    public static String formatDateShort(Date date) {
        return D_FORMAT_SHORT.format(date);
    }

    public static String formatTimeShort(Date date) {
        return T_FORMAT_SHORT.format(date);
    }

    public static String formatDateTime(Date datetime, boolean showSecond) {
        if(showSecond) {
            return DT_FORMAT.format(datetime);
        }
        else {
            return DT_NON_SEC_FORMAT.format(datetime);
        }
    }

    public static Date parseDate(String dateStr) {
        try {
            return D_FORMAT.parse(dateStr);
        } catch (ParseException e) {
        }
        return null;
    }

    public static Date parseDateShort(String dateStr) {
        try {
            return D_FORMAT_SHORT.parse(dateStr);
        } catch (ParseException e) {
        }
        return null;
    }

    public static Date parseDateTime(String datetimeStr, boolean withSecond) {
        try {
            if(withSecond) {
                return DT_FORMAT.parse(datetimeStr);
            }
            else {
                return DT_NON_SEC_FORMAT.parse(datetimeStr);
            }
        } catch (ParseException e) {
        }
        return null;
    }

    public static Date parseTime(String timeHourMin) {
        try {
            return T_FORMAT_SHORT.parse(timeHourMin);
        } catch (ParseException e) {
        }

        return null;
    }

    public static Date getDefaultFromDate() {
        return createDate(2013, 1, 1);
    }

    public static Date getDefaultToDate() {
        return createDate(2049, 12, 31);
    }

    public static Date createDateActual(int year, int month, int dayOfMonth) {
        return createDate(year, month - 1, dayOfMonth);
    }

    public static Date createDate(int year, int month, int dayOfMonth) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        setDateOnly(cal);

        return cal.getTime();
    }

    public static String getDefaultLoginPassword(Date dob) {
        return D_PWD_FORMAT.format(dob);
    }

    public static String getCurrentMonth() {
        return M_FORMAT.format(new Date());
    }

    public static String getNextMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);
        //cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
        return M_FORMAT.format(cal.getTime());
    }

    /**
     * @param date
     * @return int val in yyyyMMdd
     */
    public static int getDateInt(Date date) {
        return Integer.parseInt(formatDateShort(date));
    }


    /**
     * @param date
     * @return int val in hh24mm
     */
    public static int getTimeInt(Date date) {
        return getTimeInt(formatTimeShort(date));
    }

    public static int getTimeInt(String tmStr) {
        tmStr = tmStr.replaceFirst(":", "");
        if(tmStr.startsWith("0")) {
            tmStr = tmStr.substring(1, 4);
        }
        return Integer.parseInt(tmStr);
    }

    public static Date getMonthEnd(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, maxDay);
        return cal.getTime();
    }

    public static Date getDate(Date date, int numOfDays, boolean dateOnly) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if(numOfDays != 0) {
            cal.set(Calendar.DAY_OF_YEAR, cal.get(Calendar.DAY_OF_YEAR) + numOfDays);
        }

        if(dateOnly) {
            setDateOnly(cal);
        }

        return cal.getTime();
    }

    public static Date getDate(Date date, int numOfDays, int hoursInAdvance) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if(numOfDays != 0) {
            cal.set(Calendar.DAY_OF_YEAR, cal.get(Calendar.DAY_OF_YEAR) + numOfDays);
        }

        if(hoursInAdvance != 0) {
            cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) - hoursInAdvance);
        }

        return cal.getTime();
    }


    /**
     * @param date
     * @param timeHourMin
     * @param minsAddMinus	+ (add), - (minus)
     * @return
     */
    public static Date getDate(Date date, String timeHourMin, int minsAddMinus) {
        Calendar cal = Calendar.getInstance();

        if(!StringUtil.isEmpty(timeHourMin)) {
            if(timeHourMin.length() == 4) {
                timeHourMin = timeHourMin.substring(0, 2) + ":" + timeHourMin.substring(2, 4);
            }
            String dt = D_FORMAT.format(date) + " " + timeHourMin;
            cal.setTime(parseDateTime(dt, false));
        }
        else {
            cal.setTime(date);
        }

        if(minsAddMinus != 0) {
            cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + minsAddMinus);
        }

        return cal.getTime();
    }

    public static List<Date> getDatesBetween(Date startDate, Date endDate){
        List<Date> dates = new ArrayList<Date>();
        dates.add(startDate);

        int endDateInt = getDateInt(endDate);

        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);

        while(true) {
            if(getDateInt(cal.getTime()) >= endDateInt) {
                break;
            }

            cal.set(Calendar.DAY_OF_YEAR, cal.get(Calendar.DAY_OF_YEAR) + 1);
            dates.add(cal.getTime());
        }

        return dates;
    }

    public static void main(String[] args) {
        Date d = getCurrentDate();
        System.out.println("Date only, now=" + new Date());
        System.out.println(formatDate(d));
        System.out.println(formatDateTime(d, true));
        System.out.println(formatDateTime(d, false));

        d = getCurrentDateTime(true);
        System.out.println("\nDatetime with second, now=" + new Date());
        System.out.println(formatDate(d));
        System.out.println(formatDateTime(d, true));
        System.out.println(formatDateTime(d, false));

        d = getCurrentDateTime(false);
        System.out.println("\nDatetime without second, now=" + new Date());
        System.out.println(formatDate(d));
        System.out.println(formatDateTime(d, true));
        System.out.println(formatDateTime(d, false));


    }
}