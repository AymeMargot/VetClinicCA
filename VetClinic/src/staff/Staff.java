package staff;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

import animal.Animal;
import general.headerFooter;
import task.Task;

public class Staff {
	
	protected int number;
	protected String name;
	protected String surname;
	protected int salaryLevel;
	protected String category;
	
	protected boolean assignAnimals;
	
	protected  HashSet<Task> tasks = new HashSet<Task>();	
	protected  HashSet<Animal> animals = new HashSet<Animal>();	
	protected  Queue<Animal> lookAfterAnimals = new LinkedList<Animal>();	
	
	public headerFooter top = new headerFooter();

	public Staff() {
		this.number = 0;
		this.name = "";
		this.surname = "";
		this.salaryLevel = 0;
		category= this.getClass().getSimpleName();
		assignAnimals=false;
	}
	
	public Staff(int number,String name,String surname,int salaryLevel) {
		this.number = number;
		this.name = name;
		this.surname = surname;
		this.salaryLevel = salaryLevel;
		category= this.getClass().getSimpleName();
	}
	
	public boolean assignAnimals() {
		return(animals.size()!=0);
	}
	
	
	public void orderAnimals() {		
		Set<Animal> treeSet = new TreeSet<Animal>(animals);
		lookAfterAnimals.clear();
		Iterator<Animal> eachAnimal = treeSet.iterator();
		while (eachAnimal.hasNext()) {
			lookAfterAnimals.add(eachAnimal.next());	
		}			
		for(Animal animal : treeSet) {
			String row = "   "+animal.getCode()+top.spaces(String.valueOf(animal.getCode()),6)+animal.getName()+top.spaces(animal.getName(),15)+animal.getCategory()+top.spaces(animal.getCategory(),15)+animal.getAge()+top.spaces(String.valueOf(animal.getAge()),6)+animal.getMedicalCondition().getName();
			System.out.println(row);
		}
	}
	
	public void printAnimals() {
		Set<Animal> treeSet = new TreeSet<Animal>(animals);
		lookAfterAnimals.clear();
		Iterator<Animal> eachAnimal = treeSet.iterator();
		while (eachAnimal.hasNext()) {
			lookAfterAnimals.add(eachAnimal.next());	
		}
	}
	
	public void printAnimalsLookAfter() {
		for (Animal animal : lookAfterAnimals) {
			String row = "   "+animal.getCode()+top.spaces(String.valueOf(animal.getCode()),6)+animal.getName()+top.spaces(animal.getName(),15)+animal.getCategory()+top.spaces(animal.getCategory(),15)+animal.getAge()+top.spaces(String.valueOf(animal.getAge()),6)+animal.getMedicalCondition().getName();
			System.out.println(row);
		}
	}

	public boolean isContained(Task task) {
		
		ArrayList<Task> aux = new ArrayList<Task>(tasks);
		int i=0;
		while(i < aux.size()) {
			if(aux.get(i).getCode() == task.getCode())
				return true;
			i++;
		}       
        return false;
    }
	
		
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getAnimals() {
		return ""+animals;
	}
	
	public String getTasks() {
		return ""+tasks;
	}
	
	public int getNumberAnimals() {
		return animals.size();
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

	public int getNumberlookAfter() {
		return lookAfterAnimals.size();
	}
	
	public Animal getTopLookAfter() {
		Animal animal = lookAfterAnimals.peek();
		animals.remove(animal);
		return lookAfterAnimals.remove();		
	}
	
	public Animal getNextLookAfter() {
		return lookAfterAnimals.peek();		
	}
	
	@Override
    public String toString() {
       return "Cod"+number+"  "+name+" - "+surname+"("+category+")" ;
    }

}
