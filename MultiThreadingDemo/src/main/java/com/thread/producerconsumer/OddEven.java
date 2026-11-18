package com.thread.producerconsumer;

class NumberPrinter {

	int num;
	boolean isOddNumber = true;

	public synchronized void printEven(int num) {
		while (isOddNumber) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(num);
		isOddNumber = true;
		notify();
	}

	public synchronized void printOdd(int num) {
		while (!isOddNumber) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(num);
		isOddNumber = false;
		notify();
	}
}

public class OddEven {

	public static void main(String[] args) {
		NumberPrinter numberholder = new NumberPrinter();

		Runnable odd = () -> {
			for (int i = 1; i < 10; i = i + 2) {
				numberholder.printOdd(i);
			}
		};

		Runnable even = () -> {
			for (int i = 2; i < 10; i = i + 2) {
				numberholder.printEven(i);
			}
		};

		Thread t1 = new Thread(odd);
		Thread t2 = new Thread(even);
		
		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
