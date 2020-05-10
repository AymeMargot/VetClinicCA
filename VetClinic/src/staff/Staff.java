package staff;

import java.util.HashSet;

public class Staff {
	
	protected int number;
	protected String name;
	protected String surname;
	protected int salaryLevel;
	protected String category;
	
	protected  HashSet<Integer> tasks = new HashSet<Integer>();	
	protected  HashSet<Integer> animals = new HashSet<Integer>();	

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
	
	public boolean taskHere(int task) {
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

	public void setAnimal(int code) {
		animals.add(code);
	}
	
	
	@Override
    public String toString() {
       return "[("+number+"), "+name+","+surname+","+salaryLevel+",("+category+"), Duties: "+tasks+"]" ;
    }
}
