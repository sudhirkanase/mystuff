package com.java8.training5;

import java.util.List;
import java.util.Timer;

public class ParellelStreamDemo {

	public static void main(String[] args) {
		List<Emp> createemp = CreateEmpMgr.createemp(50000);
		
		
		long start = System.currentTimeMillis();
		
		createemp.stream().map((e) -> {
				e.setEname(e.getEname().toUpperCase());
				return e;
			}).forEach(System.out::println);
		
		long end = System.currentTimeMillis();
		
		System.out.println("Total time for serial in ms ->" + (end-start));
		
		 start = System.currentTimeMillis();
		
		createemp.stream().parallel().map((e) -> {
				e.setEname(e.getEname().toUpperCase());
				System.out.println("Active count " + Thread.activeCount());
				return e;
			}).forEach(System.out::println);
		
		 end = System.currentTimeMillis();
		
		System.out.println("Total time for parellel in ms ->" + (end-start));
		
	}

}
