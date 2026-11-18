package com.java8.training7;

import java.util.function.BinaryOperator;

class  MyCalc<T> {	
	public  T perform(BinaryOperator<T> myfunct , T val1 , T val2) {
		return myfunct.apply(val1, val2);
	}
}

public class Calc {
	
	public static void main(String[] args) {
		
		MyCalc<Integer> myCalc = new MyCalc<Integer>();
		
		BinaryOperator<Integer> add = (i, j) -> i+j;
		System.out.println(myCalc.perform(add, 10,20));
		
		BinaryOperator<Integer> substrct = (i, j) -> i-j;
		System.out.println(myCalc.perform(substrct, 100,20));
		
		BinaryOperator<Integer> multiply = (i, j) -> i*j;
		System.out.println(myCalc.perform(multiply, 10,20));
		
		BinaryOperator<Integer> divide = (i, j) -> i/j;
		System.out.println(myCalc.perform(divide, 100,20));
	}

}
