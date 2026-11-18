package com.java8.training5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamMapReduce {

	public static void main(String[] args) {

		List<String> str = new ArrayList<String>(Arrays.asList("aa", "bb", "cc", "dd"));

		Optional<String> reduce = str.stream().map((p) -> p.toUpperCase()).reduce((a, b) -> a + b);

		if (reduce.isPresent()) {
			System.out.println(reduce.get());
		}
		// append the string.. it will return the single output. it will work as
		// accumaltor
		System.out.println(str.stream().reduce((a, b) -> a + b).get());

		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		list.add("aaa");
		Optional<String> ostr = list.stream().reduce((s1, s2) -> s1 + s2);
		if (ostr.isPresent())
			System.out.println("OSTR get  = " + ostr.get());

		List<Integer> ilist = new ArrayList<Integer>();
		ilist.add(10);
		ilist.add(20);
		ilist.add(30);
		ilist.add(43);
		ilist.add(3);
		ilist.add(44);

		System.out.println("get = " + ilist.stream().reduce((s1, s2) -> {
			System.out.println("s1 " + s1 + "  s2  " + s2 );
			if (s1 >= s2)
				return s1;
			else
				return s2;
		}).get());
		//list.re
		
		list.forEach((e) ->{
			if(list.contains("ddd")) {
				list.remove("ddd");
			}
			System.out.println(e);
		});
		
		
		list.stream().forEach((e) ->{
			if(list.contains("ddd")) {
				list.remove("ddd");
			}
			System.out.println(e);
		});
		

	}
}
