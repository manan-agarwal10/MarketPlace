package MarketPlace;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c[]= {'A','B','W','G'};
		Market m=new Market(40);
		int n=10;
		while(n-->0)
		{
			Random r=new Random();
			int ch=r.nextInt(10);
			System.out.println("Thread no"+ch);
			int ftype=r.nextInt(4);
			int quan=r.nextInt(10);
			int conquan=r.nextInt(5);
			if(ch<=6) 
			{
				Thread t=new Thread(new Consumer(c[ftype],conquan,m));
				t.start();
			}
			else 
			{
				Thread t=new Thread(new Farmer(m,c[ftype],quan));
				t.start();
			}
		}
	}

}
