package animal;

import animalFactory.Condition;
/*
 * Cat is a subclass of Animal
 */
public class Cat extends Animal {
	// Defining the limit Age for a cat 14
	protected static int limitAge = 14;
	// Constructor
	public Cat(int code, String name, Condition condition) {
		
		super(code, name, condition);
		// After initialize an Animal, pick up the age between 0 and the limit age 14
		this.age= this.randomAge.nextInt(limitAge);
	}

}
