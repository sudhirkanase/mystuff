package com.study.java8;

interface Test {

	void test();
}

public class FunctionalReference {

	public  static void test2() {
		System.out.println("Hello");
	}

	public static void main(String[] args) {
		Test t = FunctionalReference::test2;
		t.test();
	}
}
