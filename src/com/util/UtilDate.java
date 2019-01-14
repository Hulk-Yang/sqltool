package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilDate {

	public static String  getNowFomatDate(String fomat){
		SimpleDateFormat df = new SimpleDateFormat(fomat); //24Сʱ��
		return df.format(new Date());
	}
	public static String  getFomatDate(Date date){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //24Сʱ��
		return df.format(date);
	}
}
