package staff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import animal.Animal;
import task.Task;

public class Staff {
	
	protected int number;
	protected String name;
	protected String surname;
	protected int salaryLevel;
	protected String category;
	
	protected  HashSet<Task> tasks = new HashSet<Task>();	
	protected  HashSet<Animal> animals = new HashSet<Animal>();	

	public Staff() {
		this.number = 0;
		this.name = "";
		this.surname = "";
		this.salaryLevel = 0;
		category= this.getClass().getSimpleName();	
	}
	
	public Staff(int number,String name,String surname,int salaryLevel) {
		this.number = number;
		this.name = name;
		this.surname = surname;
		this.salaryLevel = salaryLevel;
		category= this.getClass().getSimpleName();
	}
	
	public void orderAnimals() {
		
		Set<Animal> treeSet = new TreeSet<Animal>(animals);
		System.out.println("Sorted elements\n"+ treeSet);
	}
	
	public boolean taskHere(Task task) {
		return (tasks.contains(task));
	}	
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getAnimals() {
		return "animals: "+animals;
	}
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getSalaryLevel() {
		return salaryLevel;
	}

	public void setSalaryLevel(int salaryLevel) {
		this.salaryLevel = salaryLevel;
	}

	public void setAnimal(Animal animal) {
		animals.add(animal);
	}
	
	
	@Override
    public String toString() {
       return "[("+number+"), "+name+","+surname+","+salaryLevel+",("+category+"), Duties: "+tasks+"]" ;
    }
}
