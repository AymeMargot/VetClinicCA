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
		
		if(staff.getAllSize() != 0) 
			staff.printStaff();
		else {
		
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
		
		if(factory.getSize() != 0) 
			factory.printAnimals();
		else {
		
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
	}
	
	public void listAnimalByCategory() {
	
		if(factory.getSize() == 0) {
			System.out.println("There are no animals into the factory, please go option 5 first");
		}
		else {
			
			int option = animalsCategory.print();
			while(option != animalsCategory.getSize() && option!=-1) {
				if(option != -2) {
					String category = animalsCategory.getName(option);
					factory.printAnimalsByCategory(category);
				}
				option = animalsCategory.print();
			}
		}		
	}
	
	public void searchAnimalByName() {
		
		if(factory.getSize() == 0) {
			System.out.println("There are no animals into the factory, please go option 5 first");
		}
		else {
			
			System.out.print("Enter the name animal you are looking for: ");
			try{
				String searching = text.nextLine();
				factory.searchAnimalByName(searching);
			}
			catch(Exception e) {
				System.out.println("data invalid!!, please try again");
			}	
		}		
	}
	
	public void listAnimalsAssignedToStaff() {
		
		if(staff.getSizeMedical() == 0 || factory.getSize() == 0) {
			System.out.println("There are no staff in the company, or animals into the factory, please go option 1, and option 5 first");
		}
		else {
			staff.assignAnimals(factory);
			staff.printStaffAnimals();
		}		
	}
	
	public void listAnimalsByMedical() {
		
		if(staff.getSizeMedical() == 0 || factory.getSize() == 0) {
			System.out.println("There are no medical staff in the company, or animals into the factory, please go option 1, and option 5 first");
		}
		else {
			
			System.out.print("Enter the name medical staff you are looking for: ");
			try{
				String searching = text.nextLine();
				staff.searchAnimalsByMedical(searching);
			}
			catch(Exception e) {
				System.out.println("data invalid!!, please try again");
			}	
		}
	}
	
	public void listAnimalsByLookAfter() {
		if(staff.getSizeMedical() == 0 || factory.getSize() == 0) {
			System.out.println("There are no staff in the company, or animals into the factory, please go option 1, and option 5 first");
		}
		else {
			
			System.out.print("Enter the name medical staff: ");
			try{
				String searching = text.nextLine();
				staff.searchStaffByLookAfter(searching);
			}
			catch(Exception e) {
				System.out.println("data invalid!!, please try again");
			}	
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
			  case 6:
				  listAnimalByCategory();
				break;
			  case 7:
				  searchAnimalByName();
				break;
			  case 8:
				  listAnimalsAssignedToStaff();
				break;
			  case 9:
				  listAnimalsByMedical();
				break;
			  case 10:				 
				  listAnimalsByLookAfter();
				break;
			  default:
			    System.exit(0);
			}			
			
		}while(option != menu.getExit());
		System.out.println("You log out from the System...");
	}
	
	public static void main(String[] args) {
	
		main system= new main();
		
		system.run();

	}

}
