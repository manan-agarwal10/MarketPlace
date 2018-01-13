package MarketPlace;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
public class Market {
	public final int CAPACITY;
	AtomicInteger currentValue;
	public HashMap<Character,Fruit> slots;
//	public Map<Character,ThreadGroup> consList ;
	public Market(int cap) 
	{
		CAPACITY=cap;
		currentValue=new AtomicInteger(0);
		slots=new HashMap<>();
		slots.put('A', new Fruit());
		slots.put('W', new Fruit());
		slots.put('G', new Fruit());
		
	/*	consList=new HashMap<>();
		consList.put('A', new ThreadGroup("A"));
		consList.put('G', new ThreadGroup("G"));
		consList.put('W', new ThreadGroup("W"));*/
	}
	
	synchronized public void updateMarket(Fruit f) 
	{
		Fruit oldf=slots.get(f.getFruit());
		oldf.addQuan(f.getQuan());
//		consList.get(f.fruit).resume();
	}
	
	synchronized public boolean addProduce(Fruit f) 
	{
		if(currentValue.get()+f.getQuan()<=CAPACITY) 
		{
			updateMarket(f);
		}
		return false;
	}
	
	synchronized public void consume(Fruit f) 
	{
		char fname=f.getFruit();
		if(slots.containsKey(fname))
		{	Fruit oldf=slots.get(fname);
			if(f.getQuan()<currentValue.get()&&f.getQuan()<=oldf.getQuan()) 
			{
				System.out.println("Updating market with values"+f.toString());
				oldf.addQuan(f.getQuan()*-1);
			}
		}
	}
	

}
