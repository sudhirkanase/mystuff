package com.java8.training2;

public class StaticInterface {

	public static void main(String[] args) {
		MyInterface1 imp1 = new MyNewImp1();
		imp1.m1();
		imp1.m2();
		MyInterface1.m3();

		imp1 = new MyNewImp2();
		imp1.m1();
		imp1.m2();
		MyInterface1.m3();
	}
}

interface MyInterface1 {

	void m1();
	void m2();

	static void m3() {
		System.out.println("From my static class");
	}
}

class MyNewImp1 implements MyInterface1{

	@Override
	public void m1() {
		System.out.println("From m1");
	}

	@Override
	public void m2() {
		System.out.println("From m2");
	}
	
}


class MyNewImp2 implements MyInterface1{

	@Override
	public void m1() {
		System.out.println("From m1");
	}

	@Override
	public void m2() {
		System.out.println("From m2");
	}
	
	//@Override
	public void m3() {
		System.out.println("From m3");
	}
	
}
