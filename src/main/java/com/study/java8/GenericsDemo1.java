package com.study.java8;

import java.util.Iterator;

public class GenericsDemo1 {

	
	public static void main(String[] args) {
		MyCollection<String> str = new MyCollection<String>();
		
		Iterator<String> iterator = str.iterator();
	}
}

class MyCollection<T> implements Iterable<T>{

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new MyIterator<T>();
	}
	
}

class MyIterator<T> implements Iterator<T>{

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T next() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
