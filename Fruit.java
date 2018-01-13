package MarketPlace;

class Fruit {
	char fruit;
	int quan;
	public Fruit(char c,int n) 
	{
		fruit=c;
		this.quan=n;
	}
	public Fruit() {}
	public char getFruit() {
		return fruit;
	}
	public void setFruit(char fruit) {
		this.fruit = fruit;
	}
	public int getQuan() {
		return quan;
	}
	public void setQuan(int quan) {
		this.quan = quan;
	}
	public void addQuan(int n) 
	{
		quan+=n;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return fruit+"  "+quan;
	}
}
