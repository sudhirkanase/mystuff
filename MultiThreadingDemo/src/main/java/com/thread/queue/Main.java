package com.thread.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

	public static void main(String[] args) {
		MyQueue<Integer> myQueue = new MyQueue<Integer>();
		
		AtomicInteger cnt = new AtomicInteger();

		int enQueueCnt = 1;
		int deQueueCnt = 1;
		Random rand = new Random();
		List<Thread> threds = new ArrayList<Thread>();
		for (int i = 0; i < enQueueCnt; i++) {
			threds.add(new Thread(() -> {
				while (true)
					myQueue.enqueue(cnt.getAndIncrement());
			}));
		}

		for (int i = 0; i < deQueueCnt; i++) {
			threds.add(new Thread(() -> {
				while (true)
					System.out.println("Dequeue Item " + myQueue.dequeue());
			}));
		}

		for (Thread thread : threds) {
			thread.start();
		}
	}

}

class MyQueue<T> {
	QueueNode<T> rear;
	QueueNode<T> front;

	public synchronized void enqueue(T t) {
		QueueNode<T> newNode = new QueueNode<T>(t);
		if (front == null) {
			front = newNode;
			rear = newNode;
		} else {
			rear.next = newNode;
			rear = newNode;
		}
	}

	public synchronized T dequeue() {
		if (front == null) {
			// empty queue
			return null;
		}
		QueueNode<T> removedNode = front;
		front = front.next;

		// Single node available in the queue
		if (front == null) {
			rear = null;
		}
		return removedNode.value;
	}
}

class QueueNode<T> {
	T value;
	QueueNode<T> next;

	public QueueNode(T t) {
		value = t;
	}

}
