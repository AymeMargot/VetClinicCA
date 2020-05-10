package animal;

import java.util.Random;

import animalFactory.ProcessMedicalCondition;

public abstract class Animal {
	
	protected Integer code;
	protected String name;
	protected Integer age;
	protected Integer medicalCondition;
	protected String category;
	protected int priorityLookAfter;
	protected boolean lookAfter;
	
	protected Random randomAge = new Random();
	
	public Animal(int code, String name, int condition) {
		
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

	public int getPriorityLookAfter() {
		return priorityLookAfter;
	}

	public void setPriorityLookAfter(int priorityLookAfter) {
		this.priorityLookAfter = priorityLookAfter;
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

	public Integer getMedicalCondition() {
		return medicalCondition;
	}

	public void setMedicalCondition(int medicalCondition) {
		this.medicalCondition = medicalCondition;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String toString(){ 
		
		ProcessMedicalCondition healthConditions = new ProcessMedicalCondition();
		String condition = healthConditions.getCondition(medicalCondition);
		return "[("+code+"), "+name+","+age+","+condition+",("+category+") "+ this.priorityLookAfter+"]";  
	} 
	
	
	
}
