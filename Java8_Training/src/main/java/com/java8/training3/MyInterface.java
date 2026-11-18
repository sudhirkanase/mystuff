package com.java8.training3;

import java.util.List;
public interface MyInterface<T> {
	public default void insert(T t){
		System.out.println("insert of MyInterface invoked...");
		list().add(t);
	}
	//public void delete(T t);
	public default void delete(T t) {
		list().remove(t);
	}
	public void update(T t);
	public List<T> list();
}


/*
public interface MyInterface<T> {
	public void insert(T t);
	public void delete(T t);
	public void update(T t);
	public List<T> list();
}
*/