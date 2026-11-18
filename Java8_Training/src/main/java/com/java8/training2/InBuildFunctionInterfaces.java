package com.java8.training2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import com.google.common.base.Predicate;

public class InBuildFunctionInterfaces {
	
	public static void main(String[] args) {
		
		Function<String, Integer> strLen = (str) -> str.length();
		System.out.println("Length:- " + strLen.apply("Sudhir"));
		
		UnaryOperator<String> upCase = (str)->str.toUpperCase();
		System.out.println(upCase.apply("sudhir"));
		
		BinaryOperator<Integer> biOper = (i,j) -> i+j;
		System.out.println(biOper.apply(12, 12));
		
		Consumer<List<String>> cons = (lst) -> System.out.println(lst.size());
		cons.accept(new ArrayList<String>(Arrays.asList("1","2")));
		
		Predicate<Integer> isOdd = (num)-> num%2 != 0;
		System.out.println("21 isOdd :- " + isOdd.apply(21));
		System.out.println("20 isOdd :- " + isOdd.apply(20));
	}
}
