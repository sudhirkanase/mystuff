package com.thread.training2;

import java.util.concurrent.CountDownLatch;

class SelectLocationHelper extends Thread {

	private String name;
	private CountDownLatch latch;

	public SelectLocationHelper(String name, CountDownLatch latch) {
		this.name = name;
		this.latch = latch;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("location = " + name + " for " + i);
		}
		Lab4.finalloc = name;
	//	System.out.println("Your Selected Destination is " + name);
		latch.countDown();
	}

}

public class Lab4 {
	static String finalloc = "";

	public static void main(String[] args) throws Exception {
		CountDownLatch latch = new CountDownLatch(1);

		SelectLocationHelper helper1 = new SelectLocationHelper("Ladakh", latch);
		SelectLocationHelper helper2 = new SelectLocationHelper("Konark", latch);
		SelectLocationHelper helper3 = new SelectLocationHelper("Goa", latch);

		helper1.start();
		helper2.start();
		helper3.start();

		System.out.println("before await...");
		latch.await();
		System.out.println("Your selected location is " + finalloc);
	}

}