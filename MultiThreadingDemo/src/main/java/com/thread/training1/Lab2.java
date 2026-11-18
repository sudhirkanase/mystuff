package com.thread.training1;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

class Account{
	private int balance = 0;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}
class Increment extends Thread{
		
	private Account account;
	
	public Increment(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		
		for(int i = 0;i<100;i++){
			if (account.getBalance() >= 0){
				synchronized (account) {
					System.out.println("Notifying account...");
					account.notify();
				}
				
			}
			account.setBalance(account.getBalance()+1);
			System.out.println("in Increment " + i + ", current balance is "+  account.getBalance());
		
		}
	}
}
class Decrement extends Thread{
private Account account;
	
	public Decrement(Account account) {
		this.account = account;
	}
	@Override
	public void run() {
		for(int i = 0;i<100;i++){
			if (account.getBalance() <= 0){
				System.out.println(" Balance is <=   zero");
				try {
					synchronized(account){
						account.wait(150000);
					
					}
				} catch (InterruptedException e) {
				System.out.println("In InterruptedException");
				}
			}
			account.setBalance(account.getBalance()-1);
			System.out.println("in Decrement " + i + ", current balance is "+  account.getBalance());
		}	}

}

public class Lab2 {

	public static void main(String[] args) throws InterruptedException {
		
		Account acc = new Account();
		System.out.println("Current Balance = " + acc.getBalance());
		
		Thread t1 = new Increment(acc);
		t1.setName("aIncrement");
		Thread t2 = new Decrement(acc);
		t2.setName("aDecrement");
		t1.setDaemon(true);
		//t2.setDaemon(true);
		t1.start();
		t2.start();
		
		//t1.join();
		//t2.join();
		System.out.println("End Main - Current Balance = " + acc.getBalance());
	}

}