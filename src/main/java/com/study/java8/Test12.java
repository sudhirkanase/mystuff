package com.study.java8;

import java.util.concurrent.atomic.AtomicInteger;

public class Test12 {

	public static void main(String[] args) {

		AtomicInteger num = new AtomicInteger(1);

		Object lock = new Object();

		Runnable oddNumber = () -> {

			synchronized (lock) {

				while (true) {
					if (num.get() % 2 != 0) {

						try {
							System.out.println(num.get());
							System.out.println("Test odd" + num.get());
							num.incrementAndGet();		
							System.out.println("waiting ");
							lock.wait();
							//Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						//System.out.println("Ignore :- " + num.get());
					}
				}
			}

		};

		Runnable evenNumber = () -> {

			synchronized (lock) {
				while (true) {
					if ((num.get() % 2 == 0)) {
						System.out.println(num);
						System.out.println("Test even" + num.get());
						num.incrementAndGet();					
						lock.notify();
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						//System.out.println("Ignore even:- " + num.get());
						}
					//System.out.println("Notify All");
					//lock.notifyAll();
					/*
					 * try { Thread.sleep(1000); } catch (InterruptedException e) { // TODO
					 * Auto-generated catch block e.printStackTrace(); }
					 */
					}
				
				

			}

		};

		new Thread(oddNumber).start();
		new Thread(evenNumber).start();

	}

}
