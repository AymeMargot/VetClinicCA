package client;

import java.util.Scanner;

import animalFactory.AnimalFactory;
import category.Category;
import menu.Menu;
import staffFactory.StaffFactory;
import task.Task;
import taskFactory.TaskFactory;

public class main {
	
	Menu menu;
	AnimalFactory factory;	
	StaffFactory staff;			
	Category animalsCategory;
	Category staffCategory;
	TaskFactory tasks;
	Scanner number = new Scanner(System.in);
	Scanner text = new Scanner(System.in);
	
	public main() {
		
		menu = new Menu();
		factory = new AnimalFactory();
		staff = new StaffFactory();
		animalsCategory = new Category("animal");
		staffCategory = new Category("staff");
		tasks = new TaskFactory();	
		staffCategory.process();
		animalsCategory.process();
		
		tasks.produceTaskIt();
		tasks.produceTaskAccount();
		tasks.produceTaskVeterinarian();
		tasks.produceTaskNurse();
		tasks.produceTaskManager();
		tasks.produceTaskReceptionist();
	}
	
	public void listStaff() {		
		
		try {
			System.out.print("Enter number of Admin Staff you want to create: ");
			int qtyAdmin = number.nextInt();
			System.out.print("Enter number of Medical Staff you want to create: ");
			int qtyMedical = number.nextInt();
			
			staff.produceStaffAdmin(qtyAdmin);
			staff.produceStaffMedical(qtyMedical);
			staff.printStaff();
		}
		catch(Exception e) {
			System.out.println("Error, invalid number entered, try again");
		}		 
		 
	}
	
	public void listByCategory() {
		
		if(staff.getAllSize() == 0) {
			System.out.println("There are no staff in the company, please go option 1 first");
		}
		else {
			int option = staffCategory.print();
			while(option != staffCategory.getSize() && option!=-1) {
				if(option != -2) {
					String category = staffCategory.getName(option);
					staff.printStaffByCategory(category);
				}
				option = staffCategory.print();
			}
		}
	}
	
	public void listByTask() {
		
		if(staff.getAllSize() == 0) {
			System.out.println("There are no staff in the company, please go option 1 first");
		}
		else {
			int option = tasks.print();
			while(option != tasks.getSize() && option!=-1) {
				if(option != -2) {
					System.out.println("OPTION"+ option);
					Task task = tasks.getTask(option);
					staff.printStaffByTask(task,tasks);
				}
				option = tasks.print();
			}			
		}
	}
	
	public void searchByName() {
		
		if(staff.getAllSize() == 0) {
			System.out.println("There are no staff in the company, please go option 1 first");
		}
		else {
			
			System.out.print("Enter the name staff you are looking for: ");
			try{
				String searching = text.nextLine();
				staff.searchStaffByName(searching);
			}
			catch(Exception e) {
				System.out.println("data invalid!!, please try again");
			}	
		}		
	}
	
	public void listAnimals() {
		
		System.out.println("Enter the number of animals, you want to create");
		try {
			int qtyAnimal = number.nextInt();
			factory.produceAnimals(qtyAnimal);
			factory.printAnimals();
		}
		catch(Exception e) {
			System.out.println("number invalid, please try again");
		}				
	}
	
	public void run() {
		int option=0;
		do {
			option = menu.print();
			
			switch(option) {
			  case 1:
				  listStaff();			  			    
			    break;
			  case 2:
				  listByCategory();
			    break;
			  case 3:
				  listByTask();
			    break;
			  case 4:
				  searchByName();
			    break;
			  case 5:
				  listAnimals();
				break;
			  default:
			    System.exit(0);
			}			
			
		}while(option != menu.getExit());
	}
	
	public static void main(String[] args) {
	
		main system= new main();
		
		system.run();

	}

}
