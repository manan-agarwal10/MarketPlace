package com.accolite.marketPlace;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Consumer implements Runnable {
	Fruit fruit;
	static Market market;
	String name;
	boolean isPurchased = false;
	boolean isStop = false;
	static int threadCount = 0;
	CountDownLatch startSignal;
	CountDownLatch endSignal;
	

	public Consumer(char c, int n, Market m,CountDownLatch start,CountDownLatch end) {
		fruit = new Fruit(c, n);
		market = m;
		threadCount++;
		name = "Consumer" + threadCount;
		this.startSignal=start;
		this.endSignal=end;
	}

	public void consume() {
		synchronized (Market.slots.get(fruit.getFruit())) {
			if (market.canPurchase(fruit, name)) {
				market.consume(fruit, name);
				isPurchased = true;
				Market.slots.get(fruit.getFruit()).notify();
			} else {
				System.out.println(name + " cant sell so wait");
				try {
					endSignal.countDown();
					Market.slots.get(fruit.getFruit()).wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	public void entryCheck() 
	{
		if(fruit.getQuan()>=market.getCAPACITY())
			isStop=true;
	}

	@Override
	public void run() {
		startSignal.countDown();
		System.out.println(name + " Thread started");
		entryCheck();
		while (!isPurchased&&!isStop) {
			consume();
		}
		endSignal.countDown();
		return;
	}
}
