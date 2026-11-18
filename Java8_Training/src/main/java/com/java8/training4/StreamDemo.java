package com.java8.training4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
	public static void main(String[] args) {

		Stream<String> stream = Stream.of("aa", "bb", "cc");
		stream.forEach(System.out::println);

		String[] arr = new String[4];
		arr[0] = "aa";
		arr[1] = "bb";
		arr[2] = "cc";
		arr[3] = "dd";

		Stream str = Arrays.stream(arr);
		str.forEach(System.out::println);
		str = Arrays.stream(arr);

		str.forEach(System.out::println);
		// str.forEach(System.out::println);

		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");

		list.stream().forEach(System.out::println);
		list.stream().forEach(System.out::println);

	}
}
