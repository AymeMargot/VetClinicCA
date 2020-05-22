package animal;

import animalFactory.Condition;
/*
 * Rabbit is a subclass of Animal
 */
public class Rabbit extends Animal {
	// Defining the limit Age for a rabbit 8
	protected static int limitAge = 8;
	// Constructor
	public Rabbit(int code, String name, Condition condition) {
		
		super(code, name, condition);		
		// After initialize an Animal, pick up the age between 0 and the limit age 8
		this.age= this.randomAge.nextInt(limitAge);
	}

}
