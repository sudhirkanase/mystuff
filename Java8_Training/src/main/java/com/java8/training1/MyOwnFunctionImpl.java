package com.java8.training1;

public class MyOwnFunctionImpl {

	public static void main(String[] args) {
		MyInterface myInter = (a, b) -> { return (a + b); };
		System.out.println(myInter.add(10, 20));
	}
}

interface MyInterface {

	int add(int a, int b);
}
