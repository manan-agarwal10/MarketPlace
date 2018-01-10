package MarketPlace;

class Consumer implements Runnable {
	Fruit fruit;
	Market market;
	public  Consumer(char c,int n,Market m) 
	{
		fruit=new Fruit(c,n);
		market=m;
	}
	
	void purchase() 
	{
		market.addProduce(fruit);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		purchase();
	}
}
