package com.yajun.utils;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.security.InvalidParameterException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 时间工具类
 *
 * @description 
 *
 * @author huangyunsong
 * @createDate 2015年12月21日
 */
public class DateUtil {
	
	/** 1秒对应的毫秒数 */
	public static final long MILLIS_IN_A_SECOND = 1000;
	 
	/** 1分对应的秒数 */
	public static final long SECONDS_IN_A_MINUTE = 60;
	
	/** 1小时对应的分钟数 */
	public static final long MINUTES_IN_AN_HOUR = 60;
	 
	/** 1天对应的小时数 */
	public static final long HOURS_IN_A_DAY = 24;
	 
	/** 1星期对应的天数 */
	public static final int DAYS_IN_A_WEEK = 7;
	 
	/** 1年对应的月数 */
	public static final int MONTHS_IN_A_YEAR = 12;
	
	/** 1天对应的毫秒数  */
	public static final long millSecondsInOneDay = HOURS_IN_A_DAY * MINUTES_IN_AN_HOUR * SECONDS_IN_A_MINUTE * MILLIS_IN_A_SECOND;
	
	/** 1分钟对应的毫秒数  */
	public static final long millSecondsInOneMinute = SECONDS_IN_A_MINUTE * MILLIS_IN_A_SECOND;
	
	/** 时间格式化*/
	public static final String DATE_FORMAT = "yyyyMMddHHmmssSSS";
	/** 时间格式化*/
	public static final String DATE_FORMAT1 = "yyyyMMdd";
	/** 时间格式化*/
	public static final String DATE_FORMAT2 = "yyyy-MM-dd";
	/** 时间格式化*/
	public static final String DATE_FORMAT3 = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 格式化数组
	 */
	public static final String[] FORMATS = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyyMMdd", "yyyyMMddHHmmss",
			"yyyy-MM-dd HH:mm", "HH:mm", "HH:mm:ss", "yyyy-MM", "yyyyMMddHHmm", "MMdd", "yyyyMM","yyyy年MM月dd日", "yyyyMMddHHmmssS" };
	public static final String[] FORMATS_SIMPLE = { "yyyyMMdd","yyyyMM" };
	/**
	 * 获取简单的日期
	 * @return
	 */
	public static String getSimpleDate() {
		SimpleDateFormat time = new SimpleDateFormat(DATE_FORMAT);
		String now = time.format(new Date());
		
		return now;
	}
	
	/**
	 * 日期格式化
	 *
	 * @param date 日期
	 * @param formate 格式，以本类定义的格式为准，可自行添加。
	 * @return
	 *
	 * @author huangyunsong
	 * @createDate 2015年12月21日
	 */
	public static String dateToString(Date date, String formate) {
		if (date == null) {
			return "";
		}
		
		return new SimpleDateFormat(formate).format(date);
	}
	
	/**
	 * 字符串转日期 
	 *
	 * @param dateString 
	 * @param format 日期格式
	 * @return
	 *
	 * @author huangyunsong
	 * @createDate 2015年12月21日
	 */
	public static Date strToDate(String dateString, String format){
		if(dateString == null) {
			throw new InvalidParameterException("dateString cannot be null!");
		}
		try {
			return new SimpleDateFormat(format).parse(dateString);
		} catch (ParseException e) {
			throw new RuntimeException("parse error! [dateString:"+ dateString +";format:"+ format +"]");
		}
	}
	
	 /**
     * 计算两个日期之间相差的周年数，忽略时间
     * 
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getYearsBetween(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            throw new InvalidParameterException("startDate and endDate cannot be null!");
        }
        if (startDate.after(endDate)) {
            throw new InvalidParameterException("startDate cannot be after endDate!");
        }
 
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        int year1 = calendar.get(Calendar.YEAR);
        int month1 = calendar.get(Calendar.MONTH);
        int day1 = calendar.get(Calendar.DATE);
 
        calendar.setTime(endDate);
        int year2 = calendar.get(Calendar.YEAR);
        int month2 = calendar.get(Calendar.MONTH);
        int day2 = calendar.get(Calendar.DATE);
 
        int result = year2 - year1;
        if (month2 < month1) {
            result--;
        } else if (month2 == month1 && day2 < day1) {
            result--;
        }
        return result;
    }
    
    /**
     * 根据生日获取年龄
     *
     * @param birthday
     * @return
     *
     * @author huangyunsong
     * @createDate 2015年12月21日
     */
	public static int getAge(Date birthday) {
		return getYearsBetween(birthday, new Date()) + 1;
	}
	
    /**
     * 计算两个时间之间相差的天数,满一天算一天
     *
     * @param startDate
     * @param endDate
     * @return
     *
     * @author huangyunsong
     * @createDate 2015年12月21日
     */
	public static int getDaysDiffFloor(Date startDate,Date endDate){
		if (startDate == null || endDate == null) {
            throw new InvalidParameterException("startDate and endDate cannot be null!");
        }
		if (startDate.after(endDate)) {
	            throw new InvalidParameterException("startDate cannot be after endDate!");
	    }
		double days = Math.floor((endDate.getTime() - startDate.getTime()) / (double)millSecondsInOneDay);  //满一天算一天

		try {
			return Integer.parseInt(String.format("%.0f", days));
		}catch (Exception e){
			return 0;
		}
	}
	
	/**
	 * 计算两个时间之间相差的天数，不满一天按一天算
	 *
	 * @param startDate
	 * @param endDate
	 * @return
	 *
	 * @author huangyunsong
	 * @createDate 2015年12月21日
	 */
	public static int getDaysDiffCeil(Date startDate,Date endDate){
		if (startDate == null || endDate == null) {
            throw new InvalidParameterException("startDate and endDate cannot be null!");
        }
		if (startDate.after(endDate)) {
	            throw new InvalidParameterException("startDate cannot be after endDate!");
	    }
		double days = Math.ceil((endDate.getTime() - startDate.getTime()) / (double)millSecondsInOneDay);  //不满一天按一天算
		try {
			return Integer.parseInt(String.format("%.0f", days));
		}catch (Exception e){
			return 0;
		}
	}
	
	/**
	 * 统计两个日期之间包含的天数,忽略时间
	 *
	 * @param startDate
	 * @param endDate
	 * @return
	 *
	 * @author huangyunsong
	 * @createDate 2015年12月21日
	 */
    public static int getDaysBetween(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            throw new InvalidParameterException("startDate and endDate cannot be null!");
        }
        Date _startDate = org.apache.commons.lang3.time.DateUtils.truncate(startDate, Calendar.DATE);
        Date _endDate = org.apache.commons.lang3.time.DateUtils.truncate(endDate,Calendar.DATE);
        if (_startDate.after(_endDate)) {
            throw new InvalidParameterException("startDate cannot be after endDate!");
        }
        return (int) ((_endDate.getTime() - _startDate.getTime()) / millSecondsInOneDay);
    }
    
    /**
     * 计算两个时间之间相差的分钟数,满一分钟算一分钟
     *
     * @param startDate
     * @param endDate
     * @return
     *
     * @author huangyunsong
     * @createDate 2015年12月21日
     */
	public static long getMinutesDiffFloor(Date startDate,Date endDate){
		if (startDate == null || endDate == null) {
            throw new InvalidParameterException("startDate and endDate cannot be null!");
        }
		if (startDate.after(endDate)) {
	            throw new InvalidParameterException("startDate cannot be after endDate!");
	    }
		double days = Math.floor((endDate.getTime() - startDate.getTime()) / (double)millSecondsInOneMinute);
		try {
			return Integer.parseInt(String.format("%.0f", days));
		}catch (Exception e){
			return 0;
		}
	}
	
	/**
	 * 日期增加
	 *
	 * @param date 日期
	 * @param calendarType 增加类型，如：Calendar.YEAR，Calendar.DAY_OF_YEAR，Calendar.MONTH
	 * @param calendarValue
	 * @return
	 *
	 * @author huangyunsong
	 * @createDate 2015年12月21日
	 */
	public static Date add(Date date,int calendarType,int calendarValue){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(calendarType, calendarValue);
		return calendar.getTime();
	}
	
	/**
	 * 日期增加n年
	 *
	 * @param date 日期
	 * @param year 年数
	 * @return
	 *
	 * @author huangyunsong
	 * @createDate 2015年12月21日
	 */
	public static Date addYear(Date date,int year) {
		return add(date,Calendar.YEAR, year);
	}
	
	/**
	 * 日期增加n月
	 *
	 * @param date 日期
	 * @param month 月数
	 * @return
	 *
	 * @author huangyunsong
	 * @createDate 2015年12月21日
	 */
	public static Date addMonth(Date date,int month) { 
		return add(date,Calendar.MONTH, month);
	}
	
	/**
	 * 日期增加n天
	 *
	 * @param date 日期
	 * @param day 天数
	 * @return
	 *
	 * @author huangyunsong
	 * @createDate 2015年12月21日
	 */
	public static Date addDay(Date date,int day) {
		return add(date,Calendar.DAY_OF_YEAR, day);
	}
	
	/**
	 * 日期减少n年
	 *
	 * @param date 日期
	 * @param year 年数
	 * @return
	 *
	 * @author huangyunsong
	 * @createDate 2015年12月21日
	 */
	public static Date minusYear(Date date,int year) {
		return add(date,Calendar.YEAR, -year);
	}
	
	/**
	 * 日期减少n月
	 *
	 * @param date 日期
	 * @param month 月数
	 * @return
	 *
	 * @author huangyunsong
	 * @createDate 2015年12月21日
	 */
	public static Date minusMonth(Date date,int month) { 
		return add(date,Calendar.MONTH, -month);
	}
	
	/**
	 * 日期减少n天
	 *
	 * @param date 日期
	 * @param day 天数
	 * @return
	 *
	 * @author huangyunsong
	 * @createDate 2015年12月21日
	 */
	public static Date minusDay(Date date,int day) {
		return add(date,Calendar.DAY_OF_YEAR, -day);
	}
	
	/**
	 * 获取年
	 * @param time
	 * @return
	 */
	public static int getYear(Date time) {
		if (time == null) {
            throw new InvalidParameterException("time cannot be null!");
        }
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		return calendar.get(Calendar.YEAR);
	}
	
	/**
	 * 获取当前时间年
	 * @return
	 */
	public static int getCurrentYear() {
		return getYear(new Date());
	}
	
	/**
	 * 获取月
	 * @param time
	 * @return
	 */
	public static int getMonth(Date time) {
		if (time == null) {
            throw new InvalidParameterException("time cannot be null!");
        }
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		return calendar.get(Calendar.MONTH) + 1;
	}
	
	/**
	 * 获取当前时间月
	 * @return
	 */
	public static int getCurrentMonth() {
		return getMonth(new Date());
	}
	
	/**
	 * 获取日
	 * @param time
	 * @return
	 */
	public static int getDay(Date time) {
		if (time == null) {
            throw new InvalidParameterException("time cannot be null!");
        }
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * 获取当前时间日
	 * @return
	 */
	public static int getCurrentDay() {
		return getDay(new Date());
	}
	
	/**
     * 判断date1是否在date2之后，忽略时间部分
     * 
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isDateAfter(Date date1, Date date2) {
        Date theDate1 = org.apache.commons.lang3.time.DateUtils.truncate(date1,Calendar.DATE);
        Date theDate2 = org.apache.commons.lang3.time.DateUtils.truncate(date2,Calendar.DATE);
        return theDate1.after(theDate2);
    }
 
    /**
     * 判断date1是否在date2之前，忽略时间部分
     * 
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isDateBefore(Date date1, Date date2) {
        return isDateAfter(date2, date1);
    }
    
    /**
     * 判断date1是否在date2之后       如:“2015-12-06 12：05：15”.after("2015-12-06 12:17:16") = true
     *
     * @author liudong
     * @createDate 2015年12月24日
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isDatetimeAfter(Date date1, Date date2) {
        return date1.after(date2);
    }
 
    /**
     * 判断time1是否在time2之后，忽略日期部分
     * 
     * @param time1
     * @param time2
     * @return
     */
    public static boolean isTimeAfter(Date time1, Date time2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(time1);
        calendar1.set(1900, 1, 1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(time2);
        calendar2.set(1900, 1, 1);
        return calendar1.after(calendar2);
    }
 
    /**
     * 判断time1是否在time2之前，忽略日期部分
     * 
     * @param time1
     * @param time2
     * @return
     */
    public static boolean isTimeBefore(Date time1, Date time2) {
        return isTimeAfter(time2, time1);
    }
 
    /**
     * 判断两个日期是否同一天（忽略时间部分）
     * 
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDay(Date date1, Date date2) {
        return org.apache.commons.lang3.time.DateUtils.isSameDay(date1, date2);
    }
	
	/**
	 * 判断是否过期
	 *
	 * @param validTime 生产日期
	 * @param time 有效期 单位秒
	 * @return
	 *
	 * @author huangyunsong
	 * @createDate 2015年12月21日
	 */
	public static boolean isInValidTime(Date validTime, int time){
		long currTime = System.currentTimeMillis();
		long valid = validTime.getTime();
		
		return ((currTime - valid) < time*1000);
	}
	
	/**
	 * 获取时间的时间轴表示
	 * @param date
	 * @return
	 */
	public static String getTimeLine(Date date){
		long now = new Date().getTime();
		long da1 = date.getTime();
		String timeline = "";
		if(now>da1){//之前
			long a = now-da1;
			if(a/1000==0){
				timeline = "刚刚";
			}else {
				long a1 = a/1000;
				if(a1<60){
					timeline = a1+"秒前";
				} else{
					long b = a1/60;
					if(b<60){
						if(b>30){
							timeline = "半小时前";
						}else{
							timeline = b+"分钟前";
						}
					}else{
						long c = b/60;
						if(c<24){
							timeline = c+"小时前";
						}else {
							long d = c/24;
							if(d<30){
								if(d>7){
									timeline = (d/7)+"周前";
								}else{
									timeline = d+"天前";
								}
							} else{
								long e = d/30;
								if(e<12){
									timeline = e+"月前";
								} else{
									timeline = dateToString(date, "yy/MM/dd");
								}
							}
						}
					}
				}
			}
		} else {
			long a = da1-now;
			if(a/1000==0){
				timeline = "刚刚";
			}else {
			
				
				long a1 = a/1000;{
					if(a1<60){
						timeline = a1+"秒后";
					} else{
						long b = a1/60;
						
						if(b<60){
							if(b==30){
								timeline = "半小时后";
							}else{
								timeline = b+"分钟后";
							}
						}else{
							long c = b/60;
							if(c<24){
								timeline = c+"小时后";
							}else {
								long d = c/24;
								if(d<30){
									if(d%7==0){
										timeline = (d/7)+"周后";
									}else{
										timeline = d+"天后";
									}
								} else{
									long e = d/30;
									if(e<12){
										timeline = e+"月后";
									} else{
										timeline = dateToString(date, "yy/MM/dd");
									}
								}
								
							}
							
						}
					}
				}
				
			}
		}
		return timeline;
	}
	
    
    /**
     *  获取当前月份的第一天
     *
     * @author liudong
     * @createDate 2015年12月24日
     * @return
     */
    public static String getMonthFirstDay() {     
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        Calendar calendar = Calendar.getInstance();     
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));     
        String s = sdf.format(calendar.getTime());
        StringBuffer str = new StringBuffer().append(s).append(" 00:00:00");
        
        return str.toString();     
    }
    
    /**
     * 获取当前月份的最后一天
     *
     * @author liudong
     * @createDate 2015年12月24日
     * @return
     */
    public static String getMonthLastDay() {     
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        Calendar calendar = Calendar.getInstance();     
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));     
        String s = sdf.format(calendar.getTime());
        StringBuffer str = new StringBuffer().append(s).append(" 23:59:59");
        
        return str.toString();    
    }
    
   /**
     * 获取月份的第一天
     *
     * @author liudong
     * @createDate 2015年12月24日
     * @param date
     * @return
     */
    public static String getMonthFistDay(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));     
        String s = sdf.format(calendar.getTime());
        StringBuffer str = new StringBuffer().append(s).append(" 23:59:59");
        return str.toString();
    }
    
    /**
     * 获取月份的最后一天
     *
     * @author liudong
     * @createDate 2015年12月24日
     * @param date
     * @return
     */
    public static String getMonthLastDay(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));     
        String s = sdf.format(calendar.getTime());
        StringBuffer str = new StringBuffer().append(s).append(" 23:59:59");
        return str.toString();
    }
    
   /**
	 * 得到当前时间距2013-11-01 00:00:00的小时数
	 * @return
	 */
	public static String getHours(){
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = simple.parse("2013-11-01 00:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long millisecond=System.currentTimeMillis()-date.getTime();
		long temp = 1000*60*60 ;
		long hours = millisecond/temp;
		
		return Long.toString(hours);
	}
	
	
	/**
	 * 获得当前周- 周一的日期
	 *
	 * @return
	 *
	 * @author Songjia
	 * @createDate 2016年4月27日
	 */
	public static String getCurrentMonday() {
		int mondayPlus = getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus);
		Date monday = currentDate.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		String preMonday = sdf.format(monday);
		return preMonday;
	}
	
	
	/**
	 * 获得当前日期与本周一相差的天数（[-6,0]）
	 * @return
	 *
	 * @author panxili
	 * @createDate 2017年9月30日
	 */
	public static int getMondayPlus() {
		Calendar cd = Calendar.getInstance();
		// 获得今天是一周的第几天，星期日是第一天，星期一是第二天......
		int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == 1) {
			return -6;
		} else {
			return 2 - dayOfWeek;
		}
	}
	
	/**
	 * 获得当前周- 周日的日期
	 *
	 * @return
	 *
	 * @author Songjia
	 * @createDate 2016年4月27日
	 */
	public static String getPreviousSunday() {
		int mondayPlus = getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus + 6);
		Date monday = currentDate.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		String preMonday = sdf.format(monday);
		return preMonday;
	}
	
	/**
	 * 返回2个日期相差的天数
	 * @param fDate
	 * @param oDate
	 * @return
	 */
	public static int getIntervalDays(Date fDate, Date oDate) {

       if (null == fDate || null == oDate) {

           return -1;
       }

       long intervalMilli = oDate.getTime() - fDate.getTime();

       return (int) (intervalMilli / (24 * 60 * 60 * 1000));

    }
	
	/**
     * 判断date1是否与date2相等，忽略时间部分
     * 
     * @param date1
     * @param date2
     * @return
     */
	 public static boolean isDateEqual(Date date1, Date date2) {
        Date theDate1 = org.apache.commons.lang3.time.DateUtils.truncate(date1,Calendar.DATE);
        Date theDate2 = org.apache.commons.lang3.time.DateUtils.truncate(date2,Calendar.DATE);
        
        return theDate1.equals(theDate2);
    }
	 
	 /**
		 * 日期格式化
		 * 
		 * @param date 
		 * @param format 
		 * 
		 * @return 
		 */
		public static Date dateToDate(Date date, String format) {
			if (date == null) {
				throw new InvalidParameterException("date cannot be null!");
			}
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
			
			Date newDate = null;
			String dateStr = DateUtil.dateToString(date, format);
			try {
				newDate = simpleDateFormat.parse(dateStr);
			} catch (ParseException e) {
				throw new RuntimeException("parse error! [dateString:" + dateStr + ";format:" + format + "]");
			}
			
			return newDate;
		}
		
		/**
		 * Time转Date
		 * 
		 * @param time
		 * @return
		 */
		public static Date getTimeToDate(long time) {
			return new DateTime(time).toDate();
		}
		/**
		 * Timestamp转Date
		 * 
		 * @param timestamp
		 * @return
		 */
		public static Date getTimestampToDate(Timestamp timestamp) {
			return getTimeToDate(timestamp.getTime());
		}

		/**
		 * Sql Date转Date
		 * 
		 * @param date
		 * @return
		 */
		public static Date getSqlDateToDate(java.sql.Date date) {
			return getTimeToDate(date.getTime());
		}

		public static Date plusMonths(Date date, int num) {
			return new DateTime(date).plusMonths(num).toDate();
		}

		/**
		 * 指定时间的后几天
		 * 
		 * @author liaopeixin
		 * @date 2016年7月19日 下午2:46:43
		 * 
		 * @param date
		 * @param num
		 * @return
		 */
		public static Date plusDays(Date date, int num) {
			return new DateTime(date).plusDays(num).toDate();
		}

		/**
		 * 指定时间往后推N月N天
		 * 
		 * @author liaopeixin
		 * @date 2016年7月19日 下午2:50:14
		 * 
		 * @param date
		 * @param months
		 * @param days
		 * @return
		 */
		public static Date plusMonthsAndDays(Date date, int months, int days) {
			return new DateTime(date).plusMonths(months).plusDays(days).toDate();
		}
		
		/**
		 * 日期格式化
		 *
		 * @param date 日期
		 * @return
		 *
		 * @author huangyunsong
		 * @createDate 2015年12月21日
		 */
		public static String dateToString4All(Date date) {
			if (date == null) {
				return "";
			}
			
			return new SimpleDateFormat(DATE_FORMAT3).format(date);
		}
		
		/**
		 * String to date
		 * 
		 * @param str
		 * @return
		 */
		public static Date toDate(String str) {
			if (StringUtils.isBlank(str)) {
				return null;
			}
			String format = null;
			int strLen = str.length();
			for (String formats : FORMATS) {
				if (strLen == formats.length()) {
					format = formats;
					break;
				}
			}
			return DateTime.parse(str, DateTimeFormat.forPattern(format)).toDate();
		}
		/**
		 * 比较一个时间是否在某个时间段内
		 * 
		 * @author liaopeixin
		 * @date 2016年8月16日 上午11:26:31
		 * 
		 * @param time
		 *            要比较的时间
		 * @param startDate
		 *            开始时间
		 * @param endDate
		 *            结束时间
		 * @return
		 */
		public static boolean isBetweenTimes(Date time, Date startDate, Date endDate) {
			boolean flag = Boolean.FALSE;
			DateTime time1 = new DateTime(time);
			DateTime startDate1 = new DateTime(startDate);
			DateTime endDate1 = new DateTime(endDate);
			if (time1.isAfter(startDate1) && time1.isBefore(endDate1)) {
				flag = Boolean.TRUE;
			}
			return flag;
		}
		
		/**
		 * 比较一个时间是否在某个时间段内(含前不含后) 
		 *   >=startDate
		 * 	 <endDate
		 * @author liaopeixin
		 * @date 2016年8月16日 上午11:26:31
		 * 
		 * @param time
		 *            要比较的时间
		 * @param startDate
		 *            开始时间
		 * @param endDate
		 *            结束时间
		 * @return
		 */
		public static boolean isBetweenTimesIncludePre(Date time, Date startDate, Date endDate) {
			boolean flag = Boolean.FALSE;
			DateTime time1 = new DateTime(time);
			DateTime startDate1 = new DateTime(startDate).minusSeconds(1);
			DateTime endDate1 = new DateTime(endDate);
			if (time1.isAfter(startDate1) && time1.isBefore(endDate1)) {
				flag = Boolean.TRUE;
			}
			return flag;
		}
		
		/* 
	     * 将时间戳转换为时间Str
	     */
	    public static String stampToDateStr(String s){
	        String res;
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        long lt = new Long(s);
	        Date date = new Date(lt);
	        res = simpleDateFormat.format(date);
	        return res;
	    }
	    
	    /* 
	     * 将时间戳转换为时间
	     */
	    public static Date stampToDate(String s){
	        long lt = new Long(s);
	        return new Date(lt);
	    }
	    
	    
	    /**
	     * 获取某天最大时间
	    * @author liaopeixin
	    * @date 2019年5月24日 上午9:46:44 
	    * 
	    * @param date
	    * @return
	     */
	    public static Date getEndOfDay(Date date) {
	        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());;
	        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
	        return Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
	    }
	    
	    /**
	     * 获取某天最小时间
	    * @author liaopeixin
	    * @date 2019年5月24日 上午9:46:58 
	    * 
	    * @param date
	    * @return
	     */
	    public static Date getStartOfDay(Date date) {
	        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
	        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
	        return Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
	    }
	    /**
	     * 指定日期往前推N小时 N可为正负整数
	    * @author liaopeixin
	    * @date 2019年5月31日 上午9:32:25 
	    * 
	    * @param date
	    * @param num
	    * @return
	     */
	    public static Date plusHours(Date date, int num) {
			return new DateTime(date).plusHours(num).toDate();
		}
	    
	    /**
	     * 日期转字符串 yyyy-MM-dd
	    * @author liaopeixin
	    * @date 2019年6月17日 下午5:42:16 
	    * 
	    * @param date
	    * @return yyyy-MM-dd
	     */
		public static String dateToString(Date date) {
			if (date == null) {
				return "";
			}
			return new SimpleDateFormat(DATE_FORMAT2).format(date);
		}
		
		
		
		public  static  void  main(String[]  args){
					   
			System.out.println(DateUtil.isDateAfter(new Date(), DateUtil.toDate("2019-09-03")));

		}
		
}




