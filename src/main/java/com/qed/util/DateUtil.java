package com.qed.util;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static String DATE_FORMAT = "yyyy-MM-dd";

    public static String DATETIME_FORMAT = "yyyy-MM-dd HH:mm";

    /**
     * 日期
     */
    public final static String DEFAILT_DATE_PATTERN = "yyyy-MM-dd";
    /**
     * 日期
     */
    public final static String SLASH_DATE_PATTERN = "yyyy/MM/dd";

    /**
     * 日期时间
     */
    public final static String DEFAILT_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 时间
     */
    public final static String DEFAULT_TIME_PATTERN = "HH:mm:ss";

    private static final SimpleDateFormat _FORMAT = new SimpleDateFormat(DEFAILT_DATE_TIME_PATTERN);

    public static Date stringToDate(String date, String formatString) {

        if (StringQedUtil.isBlank(date) || StringQedUtil.isBlank(formatString))
            return null;

        DateFormat format = new SimpleDateFormat(formatString);

        Date result = null;

        try {
            result = format.parse(date);
        } catch (ParseException e) {

            return result;
        }

        return result;
    }

    public static String dateToString(Date date, String formatString) {

        if (null == date || StringQedUtil.isBlank(formatString))
            return null;

        DateFormat format = new SimpleDateFormat(formatString);
        
        String result = null;
        try {
            result = format.format(date);
        } catch (Exception e) {
            return result;
        }
        return result;
    }

    public static String format(Date date) {
        if (date == null) return "";
        return _FORMAT.format(date);
    }
    
	/**
	 * 计算出2个日期相差的天数
	 * @param d1
	 *            日期1
	 * @param d2
	 *            日期2
	 * @return 日期差数
	 */
	public static int countDiffDay(Date d1, Date d2) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(d1);
		c1.set(Calendar.HOUR_OF_DAY, 0);
		c1.set(Calendar.SECOND, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.MILLISECOND, 0); 
		c2.setTime(d2);
		c2.set(Calendar.HOUR_OF_DAY, 0);
		c2.set(Calendar.SECOND, 0);
		c2.set(Calendar.MINUTE, 0);
		c2.set(Calendar.MILLISECOND, 0);
		int returnInt = 0;
		if (c1.before(c2)) { //c1日期小于c2
			while (c1.before(c2)) {
				c1.add(Calendar.DAY_OF_MONTH, 1);
				returnInt++;
			}
		} else {
			while (c2.before(c1)) {
				c2.add(Calendar.DAY_OF_MONTH, 1);
				returnInt++;
			}
		}
		return (returnInt);
	}
	
	/**
	 * 获取偏移时间值
	 * @param date
	 * @param field
	 * @param offData
	 * @return
	 */
	public static Date getOffDataDate(Date date, Integer field,  Integer offData) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(field, offData);
		return cal.getTime();
	}

	/**
	 * 获取0点0分0秒的日期值
	 *
	 * @param d 传入日期
	 * @return Date 传出日期
	 */
	public static Date getDateWithZeroClock(Date d) {
		if (null == d) return null;
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}
}
