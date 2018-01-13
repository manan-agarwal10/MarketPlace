package MarketPlace;

class Consumer extends Thread implements Runnable,Person{
	Fruit fruit;
	Market market;
	String name;
	static int threadCount=0;
	public  Consumer(char c,int n,Market m) 
	{
		//super(m.consList.get(c),"");
		fruit=new Fruit(c,n);
		market=m;
		threadCount++;
		name="Consumer"+threadCount;
	}
	
	synchronized void purchase() throws InterruptedException 
	{
		if(canPurchase()) {
			System.out.println(name+"purchasing fruit"+fruit.toString());
			market.consume(fruit);
		}
		else 
		{
			wait();
		}
	}
	public boolean canPurchase() 
	{
		if(market.slots.containsKey(fruit.fruit)) 
		{
			Fruit f=market.slots.get(fruit.fruit);
			if(f.getQuan()>=fruit.getQuan())return true;
		}
		return false;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			purchase();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
