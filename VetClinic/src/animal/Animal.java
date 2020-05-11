package animal;

import java.util.Random;

import animalFactory.Condition;

public abstract class Animal implements Comparable<Animal> {
	
	protected Integer code;
	protected String name;
	protected Integer age;
	protected Condition medicalCondition;
	protected String category;
	protected boolean lookAfter;
	
	protected Random randomAge = new Random();
	
	public Animal(int code, String name, Condition condition) {
		
		this.code = code;
		this.name = name;
		this.medicalCondition = condition;
		category= this.getClass().getSimpleName();
	}

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
	
	public String toString(){ 
		return "[("+code+"), "+name+","+age+","+medicalCondition.getName()+",("+category+") "+"]";  
	} 
	
	@Override
	public int compareTo(Animal animal) {		
		return ((Integer)this.code).compareTo(animal.code);
    }
	
	
}
