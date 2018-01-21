package com.accolite.marketTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.accolite.marketPlace.*;

public class FarmerTest {
	@Test
	public void entryTest() 
	{
		CountDownLatch start=new CountDownLatch(1);
		CountDownLatch end=new CountDownLatch(1);
		Market m=Mockito.mock(Market.class);
		Mockito.when(m.getCAPACITY()).thenReturn(3);
		Farmer f=new Farmer(m,'A',4,start,end);
		Thread t=new Thread(f);
		t.start();
		try {
			end.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(Thread.State.TERMINATED,t.getState());
	}
	
	@Test
	public void waitTest() 
	{
		CountDownLatch start=new CountDownLatch(1);
		CountDownLatch end=new CountDownLatch(1);
		Market m=new Market(4);
		m.currentValue.set(2);
		Farmer f=new Farmer(m,'A',3,start,end);
		Thread t=new Thread(f);
		t.start();
		try {
			end.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(Thread.State.WAITING,t.getState());
	}
	
}
