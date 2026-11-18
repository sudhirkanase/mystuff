package com.thread.producerconsumer;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {
	
	public static void main(String[] args) {
		
		AtomicInteger num = new AtomicInteger(1);
		
		Object lock = new Object();
		
		Runnable oddNumber = () -> {
			
			synchronized (lock) {
				
				while(num.get() % 2 != 0 ) {
					try {
					System.out.println(num);
					num.incrementAndGet();					
					lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
				}
				
			}
			
		};
		
Runnable evenNumber = () -> {
			
			synchronized (lock) {
				
				while(num.get() % 2 == 0 ) {
					
					System.out.println(num);
					num.incrementAndGet();		
					lock.notify();					
				}
				
			}
			
		};
		
		new Thread(oddNumber).start();
		new Thread(evenNumber).start();
		
	}

}
