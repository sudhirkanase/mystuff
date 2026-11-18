package com.thread.training2;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Lab1Support implements Runnable{
	private String str;
	
public Lab1Support(String str) {
		this.str = str;
	}

@Override
public void run() {
	System.out.println("In run of Lab1Support in thread " + Thread.currentThread().getName());
	System.out.println(str +" length = " + str.length());
	try { 	Thread.sleep(5000); 	} catch (InterruptedException e) { 			e.printStackTrace(); 		}
}
}

public class Lab1 {

	public static void main(String[] args) {
		System.out.println("Enter a number to start ...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextInt();
	
		
	ExecutorService executorService = Executors.newFixedThreadPool(3);
		System.out.println("after executor with fixedthreadpool 3 created ");
		
		executorService.execute(new Lab1Support("aaa"));
		executorService.execute(new Lab1Support("bbb"));
		executorService.execute(new Lab1Support("aa"));
		executorService.execute(new Lab1Support("bbb"));
		executorService.execute(new Lab1Support("ddddd"));
		executorService.execute(new Lab1Support("eeeee"));
		executorService.shutdown();
		//executorService.execute(new Lab1Support("eeeee"));
		System.out.println("after execute call ");
	}

}