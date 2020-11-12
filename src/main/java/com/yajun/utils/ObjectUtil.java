package com.yajun.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * object util
 *
 */
public class ObjectUtil {

	protected final static Logger log = LoggerFactory.getLogger(ObjectUtil.class);

	/**
	 * 获取Date
	 * 
	 * @param obj
	 * @param formate
	 * @return
	 */
	public static Date getDate(Object obj, String formate) {
		if (obj != null) {
			String string = getString(obj);
			if(string == null) {
				return null;
			}
			return DateUtil.strToDate(getString(obj), formate);
		}
		return null;
	}

	/**
	 * 获取Date
	 * 
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static Date getDate(Object obj, Date defaultValue, String formate) {
		Date date = getDate(obj, formate);
		if (date != null) {
			return date;
		}
		return defaultValue;
	}

	/**
	 * 获取Long
	 * 
	 * @param obj
	 * @return
	 */
	public static Long getLong(Object obj) {
		Number answer = getNumber(obj);
		if (answer == null) {
			return null;
		} else if (answer instanceof Long) {
			return (Long) answer;
		}
		return new Long(answer.longValue());
	}

	/**
	 * 获取Long
	 * 
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static Long getLong(Object obj, long defaultValue) {
		Long val = getLong(obj);
		if (val != null) {
			return val;
		}
		return defaultValue;
	}

	/**
	 * 获取Integer
	 * 
	 * @param obj
	 * @return
	 */
	public static Integer getInteger(Object obj) {
		Number answer = getNumber(obj);
		if (answer == null) {
			return null;
		} else if (answer instanceof Integer) {
			return (Integer) answer;
		} else if (answer instanceof BigInteger) {
			return ((BigInteger)answer).intValue();
		}
		return new Integer(answer.intValue());
	}

	/**
	 * 获取Integer
	 * 
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static Integer getInteger(Object obj, int defaultValue) {
		Integer val = getInteger(obj);
		if (val != null) {
			return val;
		}
		return defaultValue;
	}

	/**
	 * 获取String
	 * 
	 * @param obj
	 * @return
	 */
	public static String getString(Object obj) {
		if (obj == null) {
			return null;
		} else {
			return obj.toString();
		}
	}

	/**
	 * 获取String
	 * 
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static String getString(Object obj, String defaultValue) {
		String val = getString(obj);
		if (val != null) {
			return val;
		}
		return defaultValue;
	}

	/**
	 * 获取BigDecimal
	 * 
	 * @param obj
	 * @return
	 */
	public static BigDecimal getBigDecimal(Object obj) {
		if (obj != null) {
			if (obj instanceof String){
				return new BigDecimal(getString(obj));
			}
			return (BigDecimal) obj;
		}
		return null;
	}

	/**
	 * 获取BigDecimal
	 * 
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static BigDecimal getBigDecimal(Object obj, BigDecimal defaultValue) {
		BigDecimal bigDecimal = getBigDecimal(obj);
		if (bigDecimal != null) {
			return bigDecimal;
		}
		return defaultValue;
	}

	/**
	 * @param obj
	 * @return
	 */
	public static Number getNumber(Object obj) {
		if (obj != null) {
			if (obj instanceof Number) {
				return (Number) obj;

			} else if (obj instanceof String) {
				try {
					String text = (String) obj;
					return NumberFormat.getInstance().parse(text);
				} catch (ParseException e) {
					log.error("Exception:", e);
				}
			}
		}
		return null;
	}
	
	//是否为Long类型
	public static boolean isValidLong(String str){
		   try{
		       long _v = Long.parseLong(str);
		       return true;
		   }catch(Exception e){
		     return false;
		   }
		}
}
