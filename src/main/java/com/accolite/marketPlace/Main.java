package com.accolite.marketPlace;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Main {

	public static void main(String[] args) {
		char c[] = { 'A', 'B', 'W', 'G' };
		Market m = new Market(40);
		int n = 10;
		CountDownLatch start=new CountDownLatch(n);
		CountDownLatch end=new CountDownLatch(n);
		while (n-- > 0) {
			Random r = new Random();
			int no_of_threads = r.nextInt(10);
			int fruit_type = r.nextInt(4);
			int quan = r.nextInt(10);
			int conquan = r.nextInt(5);
			if (no_of_threads <= 6) {
				Thread t = new Thread(new Consumer(c[fruit_type], conquan, m,start,end));
				t.start();
			} else {
				Thread t = new Thread(new Farmer(m, c[fruit_type], quan,start,end));
				t.start();
			}
		}
		try {
			start.await();
			end.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
