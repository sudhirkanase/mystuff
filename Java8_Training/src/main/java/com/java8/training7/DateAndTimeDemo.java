package com.java8.training7;

import java.time.LocalDate;

public class DateAndTimeDemo {

	
	public static void main(String[] args) {
		 LocalDate now = LocalDate.now();
		 System.out.println(now);
		 
		 now = LocalDate.of(2012,8, 22);
		 System.out.println(now);
	}
	
}
