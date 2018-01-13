package MarketPlace;

import java.util.*;

public class Farmer  implements Runnable, Person {
	int totalProduces=0;
	Market market;
	String fname;
	static int threadCount=0;
	Map<Character, Fruit> produce;

	public Farmer(Market m) {
		produce = new HashMap<>();
		produce.put('A', new Fruit('A', 0));
		produce.put('W', new Fruit('W', 0));
		produce.put('G', new Fruit('G', 0));
		threadCount++;
		fname="Farmer"+threadCount;
		this.market=m;
	}

	synchronized void addProduce(char fname,int n) {
		if (produce.containsKey(fname)) {
			Fruit oldf = produce.get(fname);
			oldf.addQuan(n);
			totalProduces += n;
			notifyAll();
		} else {
			produce.put(fname, new Fruit(fname, n));
			totalProduces += n;
		}
	}

	synchronized void sellProduce() throws InterruptedException {
		if (canSell()) {
			for (Fruit f : produce.values()) {
				market.addProduce(f);
			}
		} else {
			System.out.println(""+fname+" cant sell produce");
			wait();
		}
	}

	synchronized public boolean canSell() {
		if (market.CAPACITY - market.currentValue.get() >= totalProduces)
			{
				System.out.println(""+fname+"can sell produce");
				return true;
			}
		return false;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Running Thread"+fname);
			sellProduce();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
