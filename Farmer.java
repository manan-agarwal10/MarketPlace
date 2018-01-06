package MarketPlace;
import java.util.*;
public class Farmer {
		int totalProduces;
		HashMap<Character,Integer> produce;
		public Farmer(int n) 
		{
			totalProduces=n;
			produce=new HashMap<>();
			produce.put('A', 0);
			produce.put('O', 0);
			produce.put('G', 0);
			produce.put('W', 0);
		}
		
		void addProduce(char c,int p) 
		{
			if(produce.containsKey(c)) 
			{
				produce.put(c, p);
			}
		}
		
}
