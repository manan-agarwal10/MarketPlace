package MarketPlace;

import java.util.ArrayList;
import java.util.List;

class Fruit {
	char fruit;
	int quan;
	Market m;
	List<Object> a;
	private boolean available=true;
	public boolean getAvailable() {
		return available;
	}
	public void setAvailable(boolean a) {
		this.available = a;
		if(available==true) 
		{
		//	notify();
		}
	}
	public char getFruit() {
		return fruit;
	}
	public Fruit(char s,int n) 
	{
		this.fruit=s;
		this.quan=n;
		this.a=new ArrayList<>();
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
