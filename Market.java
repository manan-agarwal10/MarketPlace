package MarketPlace;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
public class Market {
	public final int CAPACITY;
	AtomicInteger currentValue;
	
	public HashMap<Character,Integer> slots;
	public Market(int cap) 
	{
		CAPACITY=cap;
		slots=new HashMap<>();
	}
	
	
	public void updateMarket(Fruit f) 
	{
		int n=slots.get(f.getFruit());
		slots.put(f.getFruit(),n+f.produce_no);
		int a=currentValue.get();
		currentValue.set(a+f.produce_no);
	}
	
	public boolean addProduce(Fruit f) 
	{
		if(currentValue.get()+f.getProduce_no()<=CAPACITY) 
		{
			updateMarket(f);
		}
		return false;
	}
	
	public void consume(Fruit f,int quant) 
	{
		if(quant<currentValue.get()&&quant<slots.get(f.getFruit())) 
		{
			int a=slots.get(f.fruit);
			slots.put(f.fruit,a-quant);
		}
		
	}
	
	
	
	

}
