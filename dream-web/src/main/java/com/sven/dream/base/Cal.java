package com.sven.dream.base;

import java.util.Calendar;

public class Cal {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(2012, 4, 13);
		System.out.println(c.get(Calendar.DAY_OF_YEAR));
		
		Calendar now = Calendar.getInstance();
		now.set(2015, 9, 3);
		System.out.println(now.get(Calendar.DAY_OF_YEAR));
	
		System.out.println(366 - c.get(Calendar.DAY_OF_YEAR) + 1 + 365 + 365 + now.get(Calendar.DAY_OF_YEAR));
	}
}
