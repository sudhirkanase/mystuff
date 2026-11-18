package com.study.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class GenericsDemo {
	
	public static void main(String[] args) {
		/*
		 * Lock l = new ReentrantLock(); int[] arr = { 10, 20 }; IntStream stream =
		 * Arrays.stream(arr); // stream.forEach(action); l.lock();
		 */
		
		List<Parent> parent = new ArrayList<>(Arrays.asList(new Parent(1), new Parent(2)));
		
		List<Child1> child1 = new ArrayList<>(Arrays.asList(new Child1(3), new Child1(4)));
		List<Child2> child2 = new ArrayList<>(Arrays.asList(new Child2(3), new Child2(4)));
		
		
		List<? extends Parent> child3 = new ArrayList<>(Arrays.asList(new Child1(3), new Child1(4)));
		List<? extends Parent> child4 = new ArrayList<>(Arrays.asList(new Child2(3), new Child2(4)));
		child3 = child4;
//		
//		  parent = child2;
//		  
//		  List<Child1> listB = parent;
//		 
		
		GenericsDemo.processElements(child1);
		
		
		LinkedHashMap<String, String> st = new LinkedHashMap<>(); 
		
	}
	
	public static void processElements(List<?> elements){
		   for(Object o : elements){
		      System.out.println(((Parent)o).getValue());
		   }
		}
	
	
}

class Demo<T extends Object, E extends Object> {
	T t;

	T getT() {
		return t;
	}
}

class Parent {
	int a;
	
	public Parent(int a){
		this.a =a;
	}
	
	public int getValue(){
		return a;
	}
}

class Child1 extends Parent{

	public Child1(int a) {
		super(a);
	}	

}
class Child2 extends Parent{

	public Child2(int a) {
		super(a);
	}	

}
