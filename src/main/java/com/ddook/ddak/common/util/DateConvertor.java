package com.ddook.ddak.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateConvertor {
	public static LocalDateTime convertDateToString(String strDate){
		return LocalDateTime.parse(strDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
}
