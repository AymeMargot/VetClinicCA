package animal;

import animalFactory.Condition;
/*
 * Dog is a subclass of Animal
 */

public class Dog extends Animal {
	// Defining the limit Age for a dog 8
	protected static int limitAge = 8;
	// Constructor
	public Dog(int code, String name, Condition condition) {
		
		super(code, name, condition);
		// After initialize an Animal, pick up the age between 0 and the limit age 8
		this.age= this.randomAge.nextInt(limitAge);
	}
 
}
