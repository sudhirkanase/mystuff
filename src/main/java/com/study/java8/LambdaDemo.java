package com.study.java8;

import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaDemo {
	public static void main(String[] args) {
		SayHello f1	= () ->  {System.out.println("Hello world");};	
		f1.sayHello();
		
		// Predicate
		Predicate<Integer> p1 = (p) -> { return p>100; };
		p1.test(500);
		p1.negate();
		p1.and(t -> t>100);
		p1.or(t -> t>100);

		Predicate<String> s=  Predicate.isEqual("test");
		s.test("test");
		
		//Function
		Function<Integer, Integer> funct = (p) -> p + 100;
		System.out.println(funct.apply(200));
		
	}
	
	
}

interface SayHello{
	void sayHello();
	default void  sayHello1() {
		
	}
	
	static void  sayHell21() {
		
	}
}