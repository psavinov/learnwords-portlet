package ru.psavinov.liferay.langlearn.portlet.util;

import com.liferay.portal.kernel.util.HtmlUtil;

public class ConvertUtil {

	public static String toString(Object parameter) {
		if (parameter != null) {
			return HtmlUtil.escape(parameter.toString());
		} else {
			return "";
		}
	}

	public static int toInt(Object parameter) {
		if (parameter instanceof Number) {
			return ((Number) parameter).intValue();
		} else if (parameter instanceof String) {
			try {
				return (new Integer((String)parameter)).intValue();
			} catch (Exception e) {
				return -1;
			}
		} else {
			return -1;
		}
	}

	public static long toLong(Object parameter) {
		if (parameter instanceof Number) {
			return ((Number) parameter).longValue();
		} else if (parameter instanceof String) {
			try {
				return (new Long((String)parameter)).longValue();
			}
			catch (Exception e) {
				return -1L;
			}
		} else {
			return -1L;
		}
	}

	public static boolean toBoolean(Object parameter) {
		if (parameter instanceof Boolean) {
			return ((Boolean) parameter).booleanValue();
		} else if (parameter instanceof String) {
			return Boolean.parseBoolean((String)parameter);
		} else if (parameter instanceof Number) {
			if (((Number)parameter).intValue()==0) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

}
