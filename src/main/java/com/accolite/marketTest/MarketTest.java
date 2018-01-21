package com.accolite.marketTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;

import com.accolite.marketPlace.*;

public class MarketTest {
	@Test
	public void updateTest() 
	{
		Market m=new Market(3);
		Fruit f=new Fruit('A',2);
		int a=m.currentValue.get();
		m.updateMarket(f);
		assertEquals(a+f.getQuan(), m.currentValue.get());
	}
	
	@Test
	public void canPurchaseTest() 
	{
		Market m=new Market(3);
		Fruit f=new Fruit('A',2);
		m.addFruit(f, "F1");
		assertTrue(m.canPurchase(f, "C1"));
	}


	@Test
	public void canConsumeTest() 
	{
		Market m=new Market(3);
		Fruit f=new Fruit('A',2);
		assertTrue(m.canAdd(f, "F1"));
	}
	
	@Test(timeout=2000) 
	public void multiThreadTest() 
	{
		CountDownLatch start=new CountDownLatch(1);
		CountDownLatch end=new CountDownLatch(1);
		Market m=new Market(4);
		Farmer f=new Farmer(m,'A',2,start,end);
		Consumer c=new Consumer('A', 2, m,start,end);
		Thread t=new Thread(f);
		Thread t2=new Thread(c);
		t2.start();
		t.start();
		m.currentStatus();
		try {
			t2.join();
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
