package animal;

import animalFactory.Condition;
/*
 * Horse is a subclass of Animal
 */
public class Horse extends Animal{
	// Defining the limit Age for a horse 40
	protected static int limitAge = 40;
	// Constructor
	public Horse(int code, String name, Condition condition) {
		
		super(code, name, condition);
		// After initialize an Animal, pick up the age between 0 and the limit age 40
		this.age= this.randomAge.nextInt(limitAge);
	}

}
