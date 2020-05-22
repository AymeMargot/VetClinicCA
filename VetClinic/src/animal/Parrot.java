package animal;

import animalFactory.Condition;
/*
 * Parrot is a subclass of Animal
 */
public class Parrot extends Animal{
	// Defining the limit Age for a parrot 10
	protected static int limitAge = 10;
	// Constructor
	public Parrot(int code, String name, Condition condition) {
		
		super(code, name, condition);
		// After initialize an Animal, pick up the age between 0 and the limit age 10
		this.age= this.randomAge.nextInt(limitAge);
	}

}
