package MarketPlace;

import java.util.*;

public class Farmer implements Runnable {
	Fruit fruit;
	String fname;
	Market m;
	boolean isSold = false;
	static int farmercount = 0;
	public Farmer(Market m, char c, int n) {
		farmercount++;
		this.fname = "Farmer" + farmercount;
		this.m = m;
		fruit = new Fruit(c, n);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(fname + " Thread started");
		try {
			while (!isSold) {
				System.out.println("Checking for Producer " + fname);
				synchronized (this) {
					System.out.println("In object of "+this.getClass().getName());
					if (m.canAdd(fruit,fname)) {
						System.out.println("Consumers waiting for this fruit="+m.slots.get(fruit.fruit).a.size());
						System.out.println(fname + "Adding Fruit");
						for(Object e:m.slots.get(fruit.fruit).a) 
						{
							System.out.println(e+"was waiting for this fruit and notifying"+this.fruit.fruit);
							e.notifyAll();
						}
						m.addFruit(fruit, fname);
						isSold = true;
						m.slots.get(fruit.fruit).notify();
						
					} else {
						System.out.println("Producer  " + fname + "wait");
						wait();
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
