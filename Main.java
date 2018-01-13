package MarketPlace;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Market m=new Market(20);
		Consumer c=new Consumer('A', 3, m);
		Consumer c2=new Consumer('G', 3, m);
		Consumer c3=new Consumer('W', 3, m);
		Farmer f=new Farmer(m);
		f.addProduce('A', 2);
		Farmer f2=new Farmer(m);
		f.addProduce('G', 3);
		Farmer f3=new Farmer(m);
		f.addProduce('W', 2);
		
		Thread t=new Thread(f);
		Thread t2=new Thread(f2);
		Thread t3=new Thread(f3);
		t.start();
		t2.start();
		t3.start();
		
		Thread t4=new Thread(c);
		Thread t5=new Thread(c2);
		Thread t6=new Thread(c3);
		t4.start();
		t5.start();
		t6.start();
	}

}
