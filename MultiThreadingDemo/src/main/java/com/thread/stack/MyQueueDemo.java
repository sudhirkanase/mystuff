package com.thread.stack;

class QNode<T> {
	T value;
	QNode<T> next;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public QNode<T> getNext() {
		return next;
	}

	public void setNext(QNode<T> next) {
		this.next = next;
	}


	public QNode(T value) {
		super();
		this.value = value;
	}

}

class MyQueue<T>{
	
	QNode<T> front = null , rear = null;
	
	public void enqueue(T t) {
		QNode<T> curr = new QNode<T>(t); 
		if(front == null) {
			front = curr;
			rear = curr;
		}else {
			rear.setNext(curr);
			rear = curr;
		}
	}
	
	public T dequeue() {
		T retVal = null;
		if(front!= null) {
			retVal = front.getValue();
			front = front.getNext();
		}
		return retVal;
	}
}

public class MyQueueDemo {

	public static void main(String[] args) {
		MyQueue<String> myQue = new MyQueue<String>();
		System.out.println(myQue.dequeue());
		myQue.enqueue("Hello");
		myQue.enqueue("Hello1");
		myQue.enqueue("Hello2");
		myQue.enqueue("Hello3");
		myQue.enqueue("Hello4");
		System.out.println(myQue.dequeue());
		System.out.println(myQue.dequeue());
		System.out.println(myQue.dequeue());
		System.out.println(myQue.dequeue());
		System.out.println(myQue.dequeue());
		System.out.println(myQue.dequeue());
		System.out.println(myQue.dequeue());
	}
}
