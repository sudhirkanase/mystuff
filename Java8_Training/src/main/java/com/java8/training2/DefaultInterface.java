package com.java8.training2;

public class DefaultInterface {

	public static void main(String[] args) {

		MyInterface imp1 = new MyImp1();
		imp1.m1();
		imp1.m2();
		imp1.m3();

		imp1 = new MyImp2();
		imp1.m1();
		imp1.m2();
		imp1.m3();

	}
}

interface MyInterface {

	void m1();

	void m2();

	default void m3() {
		System.out.println("My Default INterface implementation");
	}
}

class MyImp1 implements MyInterface {

	@Override
	public void m1() {
		System.out.println("From m1");
	}

	@Override
	public void m2() {
		System.out.println("From m2");
	}
}

class MyImp2 implements MyInterface {

	@Override
	public void m1() {
		System.out.println("From m1");
	}

	@Override
	public void m2() {
		System.out.println("From m2");
	}

	@Override
	public void m3() {
		System.out.println("From m3");
	}

}
