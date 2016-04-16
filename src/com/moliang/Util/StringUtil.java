package com.moliang.Util;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	public static boolean isNull(String str){
		if("".equals(str)||str==null){
			return true;
		}
		return false;
	}

	public static boolean isNull(Date date) {
		if(date == null){
			return true;
		}
		return false;
	}

	/**
	 * 验证输入的邮箱格式是否符合
	 * @param email
	 * @return 是否合法
	 */
	public static boolean emailFormat(String email)
	{
		boolean tag = true;
		final String pattern1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		final Pattern pattern = Pattern.compile(pattern1);
		final Matcher mat = pattern.matcher(email);
		if (!mat.find()) {
			tag = false;
		}
		return tag;
	}
	public static void main(String[] args) {
		
	}
}