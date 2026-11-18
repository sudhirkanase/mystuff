package com.thread.throughput;

public class Test {

	
	public static void main(String[] args) {
		MyTread t = new MyTread();
		Thread thread = new Thread(t);
		thread.start();
	}
}


class MyTread implements Runnable{
	
	@Override
	public void run() {
	System.out.println("test");
	}
}