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
/*
 * Staff this class represents every staff in the staff list
 * number: is the unique number
 * name: the staff name
 * surname: the staff surname
 * salarylevel: the salary level
 * category: the name of the class
 * assignAnimals: boolean variable, which will return true whenever the animals list will contain data
 * tasks: is a list of task type of HashSet in order to not repeat it none of them
 * animals: is a list of animals, which will contain the animals assigned, type of HashSet in order to not repeat it none of them
 * lookAfterAnimals: this is a list which will contain animals ordered by a code, the code will tell us the priority to be look after
 * this structure is a Queue, the top will be the first to go out
 * dessign : Class containing the format designing for footer or header on printing methods 
 */

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
	
	public headerFooter dessign = new headerFooter();
	// constructor
	public Staff() {
		this.number = 0;
		this.name = "";
		this.surname = "";
		this.salaryLevel = 0;
		category= this.getClass().getSimpleName();
		assignAnimals=false;
	}
	// constructor
	public Staff(int number,String name,String surname,int salaryLevel) {
		this.number = number;
		this.name = name;
		this.surname = surname;
		this.salaryLevel = salaryLevel;
		category= this.getClass().getSimpleName();
	}
	// Method will return true whenever the animals list contains elements
	public boolean assignAnimals() {
		return(animals.size()!=0);
	}
	
	// Method will print animals assigned
	public void printAnimals() {	
		//first step we need to order the list, that is why the animals list will be converted into a TreeSet structure
		Set<Animal> treeSet = new TreeSet<Animal>(animals);
		lookAfterAnimals.clear();// lookAfterAnimals is an auxiliary list, before assign animals, it need to be empty
		Iterator<Animal> eachAnimal = treeSet.iterator();
		while (eachAnimal.hasNext()) {// once we have the animals ordered, they will get added into the lookAfterAnimals queue
			lookAfterAnimals.add(eachAnimal.next());	
		}	
		// print the animals ordered
		for(Animal animal : treeSet) {
			String row = "   "+animal.getCode()+dessign.spaces(String.valueOf(animal.getCode()),6)+animal.getName()+dessign.spaces(animal.getName(),15)+animal.getCategory()+dessign.spaces(animal.getCategory(),15)+animal.getAge()+dessign.spaces(String.valueOf(animal.getAge()),6)+animal.getMedicalCondition().getName();
			System.out.println(row);
		}
	}
	
	// order animals and copy them to the lookAfterAnimals queue
	public void orderAnimals() {
		Set<Animal> treeSet = new TreeSet<Animal>(animals);
		lookAfterAnimals.clear();
		Iterator<Animal> eachAnimal = treeSet.iterator();
		while (eachAnimal.hasNext()) {
			lookAfterAnimals.add(eachAnimal.next());	
		}
	}
	// printing animals from the list lookAfterAnimals
	public void printAnimalsLookAfter() {
		orderAnimals();
		for (Animal animal : lookAfterAnimals) {
			String row = "   "+animal.getCode()+dessign.spaces(String.valueOf(animal.getCode()),6)+animal.getName()+dessign.spaces(animal.getName(),15)+animal.getCategory()+dessign.spaces(animal.getCategory(),15)+animal.getAge()+dessign.spaces(String.valueOf(animal.getAge()),6)+animal.getMedicalCondition().getName();
			System.out.println(row);
		}
	}
	// this method return true when ever a task is contained into the task list assigned
	public boolean isContained(Task task) {
		// the task list is a hash structure in order to get the data, we will convert it into a arraylist
		ArrayList<Task> aux = new ArrayList<Task>(tasks);
		int i=0;
		while(i < aux.size()) {
			if(aux.get(i).getCode() == task.getCode())// is the task code is in the list task assigned will return true
				return true;
			i++;
		}       
        return false;
    }
	// return the animal which is in the top of the list lookAfterAnimals
	public Animal getTopLookAfter() {
		Animal animal = lookAfterAnimals.peek();// getting the top animal
		animals.remove(animal);// this animal will be removed from the list
		return lookAfterAnimals.remove();	// this animal will be removed from the lookAfterAnimals list also	
	}
	// return the next animal from the list lookAfterAnimals
	public Animal getNextLookAfter() {
		return lookAfterAnimals.peek();		
	}
	// getters and setters
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
	
	
	@Override
    public String toString() {
       return "Cod"+number+"  "+name+" - "+surname+"("+category+")" ;
    }

}
