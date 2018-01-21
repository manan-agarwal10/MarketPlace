package com.accolite.marketPlace;
import java.util.ArrayList;
import java.util.List;

public class Fruit {
	private char fruit;
	int quan;
	Market m;
	public char getFruit() {
		return fruit;
	}
	public Fruit(char s,int n) 
	{
		this.setFruit(s);
		this.quan=n;
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
		return getFruit()+"  "+quan;
	}
}
