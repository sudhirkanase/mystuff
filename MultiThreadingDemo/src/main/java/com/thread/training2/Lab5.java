package com.thread.training2;

import java.util.concurrent.CyclicBarrier;

class Lab3Helper extends Thread {

	private String name;
	private CyclicBarrier barrier;

	public Lab3Helper(String name, CyclicBarrier barrier) {
		super(name);
		this.name = name;
		this.barrier = barrier;
	}

	@Override
	public void run() {
		try{
		System.out.println("in start of "+ name  + " Processing ....need to do  plastering.. colouring, furnishing");
		System.out.println("started plastering for  "+ name);
		Thread.sleep((int) (Math.random() * 1000)); 
		System.out.println("finished plastering for  "+ name +", just before await and BarrierInformation "+ barrier.getParties()  + ", "+ barrier.getNumberWaiting());
		barrier.await();
		System.out.println("started colouring for  "+ name);
		Thread.sleep((int) (Math.random() * 1000)); 
		System.out.println("finished colouring for  "+ name +", just before await and BarrierInformation "+ barrier.getParties()  + ", "+ barrier.getNumberWaiting());
		barrier.await();
		System.out.println("started furnishing for  "+ name);
		Thread.sleep((int) (Math.random() * 1000)); 
		System.out.println("finished furnishing for  "+ name);
		
		}catch(Exception e){
			System.out.println(e);
		}
	}

}

public class Lab5 {
	static String finalloc = "";

	public static void main(String[] args) throws Exception {
		
		CyclicBarrier barrier = new CyclicBarrier(3);
				
		Lab3Helper helper1 = new Lab3Helper("Flat1", barrier);
		Lab3Helper helper2 = new Lab3Helper("Flat2", barrier);
		Lab3Helper helper3 = new Lab3Helper("Flat3", barrier);
		helper1.start();
		helper2.start();
		helper3.start();
		System.out.println(" BarrierInformation "+ barrier.getParties()  + ", "+ barrier.getNumberWaiting());
		
	}

}