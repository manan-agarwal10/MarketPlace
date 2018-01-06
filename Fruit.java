package MarketPlace;

class Fruit {
	char fruit;
	int produce_no;
	
	public Fruit(char c,int n) 
	{
		fruit=c;
		produce_no=n;
	}
	public char getFruit() {
		return fruit;
	}
	public void setFruit(char fruit) {
		this.fruit = fruit;
	}
	public int getProduce_no(){
		return produce_no;
	}
}
