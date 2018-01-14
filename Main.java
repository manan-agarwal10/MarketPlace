package MarketPlace;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c[] = { 'A', 'B', 'W', 'G' };
		Market m = new Market(40);
		int n = 10;
		while (n-- > 0) {
			Random r = new Random();
			int no_of_threads = r.nextInt(10);
			int fruit_type = r.nextInt(4);
			int quan = r.nextInt(10);
			int conquan = r.nextInt(5);
			if (no_of_threads <= 6) {
				Thread t = new Thread(new Consumer(c[fruit_type], conquan, m));
				t.start();
			} else {
				Thread t = new Thread(new Farmer(m, c[fruit_type], quan));
				t.start();
			}
		}
	}

}
