package com.thread.stack;

class Node<T> {

	T value;
	Node<T> next;

	public Node(T value) {
		super();
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

}

class MyStack<T> {

	Node<T> head = null;

	public void push(T value) {

		Node curr = new Node<T>(value);
		;
		if (head == null) {
			head = curr;
		} else {
			curr.next = head;
			head = curr;
		}
	}

	public T pop() {
		T retVal = null;

		if (head != null) {
			retVal = head.getValue();
			head = head.getNext();
		}

		return retVal;
	}

}

public class MyStackDemo {

	public static void main(String[] args) {
		MyStack<String> stack = new MyStack<String>();		
		stack.push("Hello");
		stack.push("Hello1");
		stack.push("Hello2");
		stack.push("Hello3");
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println("##########################");
		
		stack.push("Hello");
		stack.push("Hello1");
		stack.push("Hello2");
		stack.push("Hello3");
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
