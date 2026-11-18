package com.java8.training1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lab {

	public static void main(String[] args) {
		// Before java 8
//		Thread t = new Thread(new MyRunnable());
//		t.start();
//
//		// with Java 8
//		Runnable r = () -> System.out.println("From my runnable java 8");
//		new Thread(r).start();
//		// or
//		new Thread(() -> System.out.println("From my runnable java 8")).start();

		Map<String, String> map = new HashMap<>();
		map.put("1", "2");
		map.put("2", "3");
		map.put("4", "4");

		map.forEach((key, value) -> {
			System.out.println(key + "  " + value);
		});

		Predicate<Entry<String, String>> predicate = (m) -> m.getKey() != null;

		System.out.println("Output");
		map.entrySet().stream().filter((m) -> m.getKey() != null).collect(Collectors.toList()).forEach(System.out::print);

		List<Integer> ss = new ArrayList<Integer>(Arrays.asList(1,2,3));
		
		Integer reduce = ss.stream().reduce(0, (a, b) -> a + b);
		
		System.out.println("\n\nss" + reduce);
		
		
		  List<Integer> list = Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4);
		  
		  list.stream().filter(i -> Collections.frequency(list, i) == 1)
          .collect(Collectors.toSet()).forEach(System.out::print);
		  
		  
		  list.stream()
          .collect(Collectors.groupingBy(Function.identity()
                  , Collectors.counting()))  // create a map {1=1, 2=1, 3=2, 4=2, 5=1, 7=1, 9=2}
          
          .entrySet().stream().peek(e->System.out.println("str- " + e))                 // Map -> Stream
          .filter(m -> m.getValue() > 1)       // if map value > 1, duplicate element
          .map(Map.Entry::getKey)
          .collect(Collectors.toSet());
}
}

class MyRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println("Form my runnable");

	}
}
