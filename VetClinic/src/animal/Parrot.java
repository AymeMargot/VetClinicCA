package animal;

import animalFactory.Condition;

public class Parrot extends Animal{
	
	protected static int limitAge = 10;
	
	public Parrot(int code, String name, Condition condition) {
		
		super(code, name, condition);
		this.age= this.randomAge.nextInt(limitAge);
		// TODO Auto-generated constructor stub
	}

}
