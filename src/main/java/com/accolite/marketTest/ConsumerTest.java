package com.accolite.marketTest;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;
import org.mockito.Mockito;

import com.accolite.marketPlace.*;
public class ConsumerTest {

	@Test
	public void entryTest() 
	{
		CountDownLatch start=new CountDownLatch(1);
		CountDownLatch end=new CountDownLatch(1);
		Market m=Mockito.mock(Market.class);
		Mockito.when(m.getCAPACITY()).thenReturn(3);
		Consumer c=new Consumer('A', 4, m,start,end);
		Thread t=new Thread(c);
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
		Consumer c=new Consumer('A', 3, m,start,end);
		Thread t=new Thread(c);
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
