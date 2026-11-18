package com.thread.training1;

class Lab2SupportOne extends Thread
{
	private String str1;
	private String str2;
	public Lab2SupportOne(String str1, String str2) {
		this.str1 = str1;
		this.str2 = str2;
	}
	@Override
	public void run() {
		System.out.println("Start of Run ....");
		synchronized (str1) {
			System.out.println("Locked Str1 for Lab2SupportOne");
			try{Thread.sleep(10000);}catch(Exception e){}
			synchronized (str2) {
				System.out.println("Locked Str2 for Lab2SupportOne, str1 already locked...");
				try{Thread.sleep(10000);}catch(Exception e){}
			}
		}

	}
	
}



class Lab1SupportOne extends Thread
{
	private String str1;
	private String str2;
	public Lab1SupportOne(String str1, String str2) {
		this.str1 = str1;
		this.str2 = str2;
	}
	@Override
	public void run() {
		System.out.println("Start of Run ....");
		synchronized (str2) {
			System.out.println("Locked Str1 for Lab2SupportOne");
			try{Thread.sleep(10000);}catch(Exception e){}
			synchronized (str1) {
				System.out.println("Locked Str2 for Lab2SupportOne, str1 already locked...");
				try{Thread.sleep(10000);}catch(Exception e){}
			}
		}

	}
	
}

public class Lab3 {

	public static void main(String[] args) {
		String str1 = "TestOne";
		String str2 = "TestTwo";
		Lab1SupportOne t1 = new Lab1SupportOne(str1,str2);
		Lab2SupportOne t2 = new Lab2SupportOne(str1,str2);
		t1.setName("T1");
		t2.setName("T2");
		t1.start();
		t2.start();

	}

}