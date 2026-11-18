package com.thread.training2;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Lab2 {
	
	
	public static void main(String[] args) {
		AtomicInteger i = new AtomicInteger();
		System.out.println("in main ..." + new Date());
		Runnable runnable = ()->{
			int cnt = i.incrementAndGet();
			System.out.println("THred number +++  " + cnt);
			System.out.println("Current Time is " + new Date() +" , from " + Thread.currentThread().getName());
			try {
				Thread.sleep(3000);
				System.out.println("THred number  -- " + cnt + "  Time:- " + new Date());
				System.out.println("---------------------------------------------");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} ;
		ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
		//service.schedule(runnable, 5,TimeUnit.SECONDS);
		//service.scheduleAtFixedRate(runnable, 5, 200, TimeUnit.MILLISECONDS);
		ScheduledFuture<?> scheduleWithFixedDelay = service.scheduleWithFixedDelay(runnable, 5, 2, TimeUnit.SECONDS);
		
	}
}