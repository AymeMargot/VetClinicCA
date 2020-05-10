package animal;

import animalFactory.Condition;

public class Dog extends Animal {
	
	protected static int limitAge = 8;
	
	public Dog(int code, String name, Condition condition) {
		
		super(code, name, condition);
		this.age= this.randomAge.nextInt(limitAge);
		// TODO Auto-generated constructor stub
	}
 
}
