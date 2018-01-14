package MarketPlace;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class Market {
	public final int CAPACITY;
	AtomicInteger currentValue;
	volatile static Map<Character, Fruit> slots;

	public Market(int cap) {
		CAPACITY = cap;
		currentValue = new AtomicInteger(0);
		slots = new HashMap<>();
		slots.put('A', new Fruit('A', 0));
		slots.put('W', new Fruit('W', 0));
		slots.put('G', new Fruit('G', 0));
		slots.put('B', new Fruit('B', 0));

	}

	public void updateMarket(Fruit f) {
		System.out.println("Updating market with values" + f);
		Fruit oldf = slots.get(f.getFruit());
		oldf.addQuan(f.getQuan());
		currentValue.addAndGet(f.getQuan());
		// consList.get(f.fruit).resume();
		System.out.println("Added to market" + f);
	}

	public void currentStatus() {
		System.out.println("total items=" + currentValue.get());
		for (Fruit f : slots.values()) {
			System.out.println(f.toString());
		}
	}

	synchronized boolean canPurchase(Fruit fruit, String name) {
		System.out.println(name + " wants " + fruit);
		System.out.println("market have " + slots.get(fruit.fruit));

		if ((currentValue.get() >= fruit.quan) && (slots.get(fruit.fruit).quan >= fruit.getQuan())) {
			return true;
		} else
			return false;
	}

	synchronized void consume(Fruit fruit, String name) {
		System.out.println(name + " consumes " + fruit + "from Market having" + slots.get(fruit.fruit));
		currentValue.addAndGet(fruit.quan * -1);
		System.out.println("Now market have " + currentValue.get());
		slots.get(fruit.fruit).addQuan(fruit.quan * -1);
		System.out.println("Now market have " + slots.get(fruit.fruit));

	}

	synchronized boolean canAdd(Fruit f, String name) {
		System.out.println(name + " wants to add  " + f);
		System.out.println("but market have tot items" + currentValue.get());

		if (CAPACITY - currentValue.get() >= f.quan) {
			return true;
		} else
			return false;
	}

	synchronized void addFruit(Fruit f, String name) {
		System.out.println(name + "Adding");
		slots.get(f.fruit).addQuan(f.quan);
		currentValue.addAndGet(f.quan);
		// for(Thread c:f.a)
		{
			// c.n
		}
	}

}
