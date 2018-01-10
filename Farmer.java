package MarketPlace;

import java.util.*;

public class Farmer implements Runnable {
	int totalProduces;
	Market market;
	HashMap<Character, Fruit> produce;

	public Farmer(int n) {
		totalProduces = n;
		produce = new HashMap<>();
		produce.put('A', new Fruit('A',0));
		produce.put('O', new Fruit('O',0));
		produce.put('G', new Fruit('G',0));
		produce.put('W', new Fruit('W',0));
	}

	void addProduce(char c, int p) {
		if (produce.containsKey(c)) {
			produce.put(c,new Fruit(c,p));
		}
	}

	void sellProduce() {
		if(market.CAPACITY-market.currentValue.get()<=totalProduces) 
		{
			//market.a
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//addProduce(c, p);
	}

}
