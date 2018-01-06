package MarketPlace;
import java.util.*;
public class Market {
	public final int CAPACITY;
	int currentValue;
	
	public HashMap<Character,Integer> slots;
	public Market(int cap) 
	{
		CAPACITY=cap;
		slots=new HashMap<>();
	}
	
	
	public void updateMarket(Fruit f) 
	{
		int n=slots.get(f.getFruit());
		slots.put(f.getFruit(),n+f.produce_no );
	}
	
	public boolean addProduce(Fruit f) 
	{
		if(currentValue+f.getProduce_no()<=CAPACITY) 
		{
			updateMarket(f);
		}
		return false;
	}
	
	

}
