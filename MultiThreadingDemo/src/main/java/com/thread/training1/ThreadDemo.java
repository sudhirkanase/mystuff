package com.thread.training1;

import java.util.Scanner;

public class ThreadDemo {

	public static void main(String[] args) {

		ThreadDemo t = new ThreadDemo();
		Scanner sc = new Scanner(System.in);
		sc.nextInt();

		Thread thread = new Thread(() -> {
			System.out.println(" called");
			for (int i = 0; i < 10000; i++) {

				System.out.println(" test");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		
		
		
		thread.setDaemon(true);
		thread.start();
		System.out.println("Exiting from main");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Exiting...");
	}
}
