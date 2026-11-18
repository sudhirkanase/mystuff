package com.thread.training1;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

class Lab1Suppport extends Thread{
	List<String> list;
	
	public Lab1Suppport(List<String> list) {
		this.list = list;
	}

	@Override
	public void run() {
	for(int i=0;i<100;i++){
		list.add(getName()+i);
	}
	System.out.println("Current List Size = " + list.size());
	}
}



public class Lab1 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		int count=100;
		for(int i=0;i<count;i++){
			Thread t1 = new Lab1Suppport(list);
			t1.setName("T"+i);
			t1.start();
		}
	
	}

}
