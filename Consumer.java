package MarketPlace;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Consumer implements Runnable {
	Fruit fruit;
	static Market market;
	String name;
	boolean isPurchased = false;
	static int threadCount = 0;

	public Consumer(char c, int n, Market m) {
		fruit = new Fruit(c, n);
		market = m;
		threadCount++;
		name = "Consumer" + threadCount;
	}

	@Override
	public void run() {
		System.out.println(name + " Thread started");
		try {
			while (!isPurchased) {
				synchronized (market.slots.get(fruit.fruit)) {
					if (market.canPurchase(fruit, name)) {
						market.consume(fruit, name);
						isPurchased = true;
						market.slots.get(fruit.fruit).notify();
					} else {
						System.out.println(name + " cant sell so wait");
						market.slots.get(fruit.fruit).wait();
					}
				}
			}
			return;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
