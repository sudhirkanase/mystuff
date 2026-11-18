package com.study.java8;

import java.util.ArrayList;
import java.util.List;

public class ConsumerProducer {
	public static void main(String[] args) {
		ItemHolder itemHolder = new ItemHolder();
		Runnable oddNumber = () -> {
			
			for(int i =1; i< Integer.MAX_VALUE; i = i+2) {
				itemHolder.produce();
			}
		};
		
		Runnable evenNumber = () -> {
			
			for(int i =2; i< Integer.MAX_VALUE; i = i+2) {
				itemHolder.consume();
			}
		};
		
		
		new Thread(oddNumber).start();
		new Thread(evenNumber).start();
	}
}


class ItemHolder{
	
	int i =0;
	int maxSize = 2;
	List<Integer> item = new ArrayList<>();
	
	
	public synchronized void produce() {
		
		if(item.size() == maxSize) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		item.add(i++);
		notify();
	}
	
	public synchronized void consume() {
		if(item.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Integer consumedItem = item.remove(0);
		System.out.println("Item consumed: -- > " + consumedItem);
		notify();
		
	}
	
	
	
	
}