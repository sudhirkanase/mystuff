package com.thread.training2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
	private final BlockingQueue<String> queue;

	Producer(BlockingQueue q) {
		queue = q;
	}

	public void run() {
		try {

			for (int i = 0; i < 100; i++) {
				System.out.println("before put");
				queue.put(Thread.currentThread().getName() + i);
				System.out.println("in put queue" + queue.peek());
			}
		} catch (InterruptedException ex) {
			System.out.println(ex);
		}
	}

}

class Consumer implements Runnable {
	private final BlockingQueue queue;

	Consumer(BlockingQueue q) {
		queue = q;
	}

	public void run() {
		try {
			for (int i = 0; i < 100; i++) {
			System.out.println("Take returned " + queue.take() + "from thread" + Thread.currentThread().getName());
			}
		} catch (InterruptedException ex) {
			System.out.println(ex);
		}
	}
}

public class Lab8 {
	public static void main(String[] args) {
		BlockingQueue<String> q = new ArrayBlockingQueue(1);
		Producer p = new Producer(q);
		Consumer c1 = new Consumer(q);
	//	Consumer c2 = new Consumer(q);
		new Thread(p).start();
		new Thread(c1).start();
		// new Thread(c2).start();
	}
}