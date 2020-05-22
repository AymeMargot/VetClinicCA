package animal;

import java.util.Random;

import animalFactory.Condition;
/*
 * Animal Class represent every single animal into the farm. 
 * Every single one is identified by 
 * code: unique number 
 * name: the name of the animal
 * age: the age of the animal, depends of the category (Which animal is), the constructor will pick up a random number 
 * 		with the limit age
 * medicalCondition: the sickness of the animal
 * category: type of animal
 * lookAfter: boolean variable with defines if the animal is lookAfter already or not
 */
public abstract class Animal implements Comparable<Animal> {
	// the class implements of Comparable in case we need to compare between 2 animal objects
	protected Integer code;
	protected String name;
	protected Integer age;
	protected Condition medicalCondition;
	protected String category;
	protected boolean lookAfter;
	// randomAge is the variable with help us to random the age of the animal
	protected Random randomAge = new Random();
	
	// Constructor 
	public Animal(int code, String name, Condition condition) {
		
		this.code = code;
		this.name = name;
		this.medicalCondition = condition;
		//category will take the name of the class in order to catch up the type of animal
		category= this.getClass().getSimpleName();
	}
	
	// Getters and Setters
	public String getName() {
		return name;
	}

	
	public boolean isLookAfter() {
		return lookAfter;
	}

	public void setLookAfter(boolean lookAfter) {
		this.lookAfter = lookAfter;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Condition getMedicalCondition() {
		return medicalCondition;
	}

	public void setMedicalCondition(Condition medicalCondition) {
		this.medicalCondition = medicalCondition;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	
	public String toString(){ 
		return name+"("+code+")";  
	} 
	
	
	public int compareTo(Animal animal) {		
		return ((Integer)this.code).compareTo(animal.code);
    }
	
	
}
