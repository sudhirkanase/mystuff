package com.study.java8;

public class EvenOddNumber {

	
	public static void main(String[] args) {
		Printer p = new Printer();
		
		Runnable oddNumber = () -> {
			
			for(int i =1; i< Integer.MAX_VALUE; i = i+2) {
				p.printOdd(i);
			}
		};
		
		Runnable evenNumber = () -> {
			
			for(int i =2; i< Integer.MAX_VALUE; i = i+2) {
				p.printEven(i);
			}
		};
		
		
		new Thread(oddNumber).start();
		new Thread(evenNumber).start();
	}
}

class Printer{
	
	boolean isOddPrinted;
	
	public synchronized void printOdd(int number) {
		while(isOddPrinted) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(Thread.currentThread().getName() +" :- " + number);
		isOddPrinted = true;
		
		notify();
		
	}
	
	public synchronized void printEven(int number) {
		while(!isOddPrinted) {
			 try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		System.out.println(Thread.currentThread().getName() +" :- " + number);
		isOddPrinted = false;
		notify();
	}
	
}
