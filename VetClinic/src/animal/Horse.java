package animal;

import animalFactory.Condition;

public class Horse extends Animal{
	
	protected static int limitAge = 40;
	
	public Horse(int code, String name, Condition condition) {
		
		super(code, name, condition);
		this.age= this.randomAge.nextInt(limitAge);
		// TODO Auto-generated constructor stub
	}

}
