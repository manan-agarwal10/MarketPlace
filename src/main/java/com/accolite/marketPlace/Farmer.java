package com.accolite.marketPlace;

import java.util.*;
import java.util.concurrent.CountDownLatch;

public class Farmer implements Runnable {
	Fruit fruit;
	String fname;
	Market m;
	boolean isSold = false;
	boolean isStop = false;
	CountDownLatch start;
	CountDownLatch end;
	static int farmercount = 0;

	public Farmer(Market m, char c, int n, CountDownLatch start, CountDownLatch end) {
		farmercount++;
		this.fname = "Farmer" + farmercount;
		this.m = m;
		fruit = new Fruit(c, n);
		this.start = start;
		this.end = end;
	}

	public void purchase() {
		System.out.println("Checking for Producer " + fname);
		synchronized (Market.slots.get(fruit.getFruit())) {
			if (m.canAdd(fruit, fname)) {
				System.out.println(fname + "Adding Fruit");
				m.addFruit(fruit, fname);
				isSold = true;
				Market.slots.get(fruit.getFruit()).notify();
			} else {
				System.out.println("Producer  " + fname + "wait");
				try {
					end.countDown();
					Market.slots.get(fruit.getFruit()).wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void entryCheck() {
		if (fruit.getQuan() >= m.getCAPACITY())
			isStop = true;
	}

	@Override
	public void run() {
		System.out.println(fname + " Thread started");
		entryCheck();
		start.countDown();
		while (!isSold & !isStop) {
			purchase();
		}
		end.countDown();
	}
}
