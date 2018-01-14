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
		// super(m.consList.get(c),"");
		fruit = new Fruit(c, n);
		market = m;
		threadCount++;
		name = "Consumer" + threadCount;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(name + " Thread started");
		try {
			while (!isPurchased) {
				synchronized (this) {
					System.out.println("In object of "+this.getClass().getName()+"\nChecking for Consumer " + name);
					if (market.canPurchase(fruit, name)) {
						// System.out.println(name+"Consuming");
						market.consume(fruit, name);
						isPurchased = true;
					} else {
						System.out.println(name + " cant sell so wait");
							market.slots.get(fruit.fruit).a.add(this);
						
						wait();
						
						
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
