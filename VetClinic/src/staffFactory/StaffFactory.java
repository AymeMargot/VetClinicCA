package staffFactory;

import java.util.LinkedList;
import java.util.Random;

import animalFactory.AnimalFactory;
import general.ProcessCode;
import general.ProcessName;
import general.headerFooter;
import staff.*;
import task.Task;
import taskFactory.TaskFactory;
/*
 * StaffFactory is a class with generate a list of staff, print them, search an specific name staff between them
 * or simple classifying them by category
 * Attributes
 * staff: list all staff
 * admin :list admin staff
 * medical:list medical staff 
 * nameGenerator: Class which generates random names
 * surnameGenerator: Class which generates random surnames
 * codeGenerator: Class with generate a unique code
 * pathFileName: Variable which defines the path of the file.txt containing names
 * pathFileSurname: Variable which defines the path of the file.txt containing surnames
 * dessign : Class containing the format designing for footer or header on printing methods 
 */

public class StaffFactory {
	
	protected LinkedList<Staff> staff;
	protected LinkedList<Staff> admin;
	protected LinkedList<Staff> medical;
	
	private static ProcessName nameGenerator;
	private static ProcessName surnameGenerator;
	private static ProcessCode codeGenerator;
	private static String pathFileName ="..\\VetClinic\\src\\staffFactory\\names.txt";	
	private static String pathFileSurname ="..\\VetClinic\\src\\staffFactory\\surnames.txt";
	
	public headerFooter dessign = new headerFooter();
	// constructor
	public StaffFactory() {
		
		staff = new LinkedList<Staff>();
		admin = new LinkedList<Staff>();
		medical = new LinkedList<Staff>();
		
		nameGenerator = new ProcessName(90,pathFileName);// the names will be pick up randomly between 90 names from the file.txt
		surnameGenerator = new ProcessName(90,pathFileSurname);	// the surnames will be pick up randomly between 90 names from the file.txt
		codeGenerator = new ProcessCode();
	}
	// Method which produces staff an put them into the list, limit is the number of staff will be generated
	public void produceStaffAdmin(int limit) {
		
		int counter=0;
		int num = 1;	
			
		while(counter < limit) {
			
			String name = nameGenerator.getName(nameGenerator.getSize());
			String surname = surnameGenerator.getName(surnameGenerator.getSize());
			int code = codeGenerator.getCode();	
			// in order to generate different types of staff is being used switch, and num is the variable which
			// help to control which type of staff has to be created, once are created the 5 categories we have, it will
			// start again switching num=0;
			switch(num) {
			  case 1:
				if(admin.add(new Account(code, name,surname,2))) {					
					staff.add(admin.get(admin.size()-1));
					counter++;
				}
			    break;
			  case 2:
				if(admin.add(new ItNerd(code, name,surname,1))) {
					staff.add(admin.get(admin.size()-1));
					counter++;
				}
			    break;
			  case 3:
				if(admin.add(new Manager(code, name,surname,1))) {
					staff.add(admin.get(admin.size()-1));
					counter++;
				}
				break;		
			  default:
				if(admin.add(new Receptionist(code, name,surname,3))) {
					staff.add(admin.get(admin.size()-1));
					counter++;
					num = 0;
				}
				break;			    
			}// end switch
			num++;		
		}// endWhile		
	}
	// Method will produce staff medical only, and put them on the medical list
	public void produceStaffMedical(int limit) {
		
		int counter=0;
		int num = 1;	
			
		while(counter < limit) {
			
			String name = nameGenerator.getName(nameGenerator.getSize());
			String surname = surnameGenerator.getName(surnameGenerator.getSize());
			int code = codeGenerator.getCode();	
			
			switch(num) {
			  case 1:
				if(medical.add(new Veterinarian(code, name,surname,1))) {
					staff.add(medical.get(medical.size()-1));
					counter++;
				}
			    break;
			  case 2:
				if(medical.add(new Nutritionist(code, name,surname,1))) {
					staff.add(medical.get(medical.size()-1));
					counter++;
				}
			    break;
			  case 3:
				if(medical.add(new Nurse(code, name,surname,2))) {
					staff.add(medical.get(medical.size()-1));
					counter++;
				}
				break;		
			  default:
				if(medical.add(new Physiotherapist(code, name,surname,1))) {
					staff.add(medical.get(medical.size()-1));
					counter++;
					num = 0;
				}
				break;			    
			}// end switch
			num++;		
		}// endWhile		
	}	
	
	// Printing all the staff in the general list
	public void printStaff() {
		
		if(staff.size() == 0) {
			System.out.println("There are no staff in the company, please try again");
		}
		dessign.header("Vet Lovely Pet - List of employees -");			
		for(int i=0; i < staff.size(); i++) {
			String row = "   "+staff.get(i).getNumber()+dessign.spaces(String.valueOf(staff.get(i).getNumber()),6)+staff.get(i).getName()+dessign.spaces(staff.get(i).getName(),15)+staff.get(i).getSurname()+dessign.spaces(staff.get(i).getSurname(),15)+staff.get(i).getCategory();
			System.out.println(row);
		}
		dessign.totalFooter("Total Employees "+ staff.size());
		dessign.footer();
	}
	//Printing the admin staff only
	public void printAdminStaff() {
		
		if(admin.size() == 0) {
			System.out.println("There are no admin staff in the company, please try again");
		}
		dessign.header("Admin Staff - List of employees -");			
		for(int i=0; i < admin.size(); i++) {
			String row = "   "+admin.get(i).getNumber()+dessign.spaces(String.valueOf(admin.get(i).getNumber()),6)+admin.get(i).getName()+dessign.spaces(admin.get(i).getName(),15)+admin.get(i).getSurname()+dessign.spaces(admin.get(i).getSurname(),15)+admin.get(i).getCategory();
			System.out.println(row);
		}
		dessign.totalFooter("Total Admin Employees "+ admin.size());
		dessign.footer();
	}
	// printingl medical staff only
	public void printMedicalStaff() {
		
		if(medical.size() == 0) {
			System.out.println("There are no medical staff in the company, please try again");
		}
		dessign.header("Medical Staff - List of employees -");			
		for(int i=0; i < medical.size(); i++) {
			String row = "   "+medical.get(i).getNumber()+dessign.spaces(String.valueOf(medical.get(i).getNumber()),6)+medical.get(i).getName()+dessign.spaces(medical.get(i).getName(),15)+medical.get(i).getSurname()+dessign.spaces(medical.get(i).getSurname(),15)+medical.get(i).getCategory();
			System.out.println(row);
		}
		dessign.totalFooter("Total Medical Employees "+ admin.size());
		dessign.footer();
	}
	// printing staff by category
	public boolean printStaffByCategory(String category) {
		
		if(staff.size() == 0) {
			System.out.println("No staff into the company, please check it");
			return false;
		}
		int counter = 0;
		dessign.header("Staff "+ category);
		for(int i=0; i < staff.size(); i++) {
			// whenever the staff belongs to the category we are looking for, the staff will be printed
			if(category.equals(staff.get(i).getCategory())) {
				// Getting the data from the staff will be printed, the spaces method will add the spaces between them making a symmetrical columns
				String row = "   "+staff.get(i).getNumber()+dessign.spaces(String.valueOf(staff.get(i).getNumber()),6)+staff.get(i).getName()+dessign.spaces(staff.get(i).getName(),15)+staff.get(i).getSurname()+dessign.spaces(staff.get(i).getSurname(),15)+staff.get(i).getCategory();
				System.out.println(row);
				counter++;
			}
		}
		dessign.totalFooter("Total: "+ counter+ "  into the company");
		dessign.footer();
		return true;
	}
	// printing the staff by a specific task
	public boolean printStaffByTask(Task task, TaskFactory tasks) {
		
		if(staff.size() == 0) {
			System.out.println("No staff into the company, please check it");
			return false;
		}
		int counter = 0;
		dessign.header("Task (Code: "+ task.getCode() +")  "+ task.getName());
		for(int i=0; i < staff.size(); i++) {
			//staff has a list of tasks, the method isContained will return true whenever the task is found
			if(staff.get(i).isContained(task)) {
				String row = "   "+staff.get(i).getNumber()+dessign.spaces(String.valueOf(staff.get(i).getNumber()),6)+staff.get(i).getName()+dessign.spaces(staff.get(i).getName(),15)+staff.get(i).getSurname()+dessign.spaces(staff.get(i).getSurname(),15)+staff.get(i).getCategory()+dessign.spaces(staff.get(i).getCategory(),20)+staff.get(i).getTasks();
				System.out.println(row);				
				counter++;
			}
		}
		dessign.totalFooter("Total: "+ counter+ "  into the company");
		dessign.footer();
		return true;
	}
	// searching by name
	public void searchStaffByName(String name) {
		if(staff.size() == 0) {
			System.out.println("No Staff into the company, please check it");
		}
		int counter = 0;
		dessign.header("Searching  "+ name);
		for(int i=0; i < staff.size(); i++) {
			if(name.toLowerCase().equals(staff.get(i).getName().toLowerCase())) {
				String row = "   "+staff.get(i).getNumber()+dessign.spaces(String.valueOf(staff.get(i).getNumber()),6)+staff.get(i).getName()+dessign.spaces(staff.get(i).getName(),15)+staff.get(i).getSurname()+dessign.spaces(staff.get(i).getSurname(),15)+staff.get(i).getCategory();
				System.out.println(row);
				counter++;
			}
		}
		dessign.totalFooter("Total: "+ counter+ "  into the company");
		dessign.footer();	
	}
	
	public void searchAnimalsByMedical(String name) {
		if(medical.size() == 0) {
			System.out.println("No Staff Medical into the company, please check it");
		}
		int counter = 0;
		dessign.header3("Searching  "+ name);
		for(int i=0; i < medical.size(); i++) {	
			
			if(name.toLowerCase().equals(medical.get(i).getName().toLowerCase())) {
				dessign.header4(medical.get(i).getName()+" "+medical.get(i).getSurname()+" "+medical.get(i).getCategory());
				if(medical.get(i).getNumberAnimals() == 0)
					System.out.println("No animals assigned");				
				else 					
					medical.get(i).printAnimals();				
				counter++;
			}
		}
		dessign.totalFooter("Total: "+ counter+ "  into the company");
		dessign.footer();	
	}
	// searching staff by look after, this method with get the animals assigned to a specific staff
	// the method will show up the first in the list and the next one
	public void searchStaffByLookAfter(String name) {
		if(medical.size() == 0) {
			System.out.println("No Staff Medical into the company, please check it");
		}
		int counter = 0;
		dessign.header3("Searching  "+ name);		
		for(int i=0; i < medical.size(); i++) {
			if(name.toLowerCase().equals(medical.get(i).getName().toLowerCase())) {
				dessign.header4(medical.get(i).getName()+" "+medical.get(i).getSurname()+" "+medical.get(i).getCategory());
				if(medical.get(i).getNumberlookAfter() == 0)
					System.out.println("No animals assigned");				
				else {
					medical.get(i).printAnimalsLookAfter();
					dessign.footer1();
					System.out.println("ROUND FOR CARING "+medical.get(i).getTopLookAfter());// getTopLookAfter will return the top animal in the list
					System.out.println("NEXT  FOR CARING "+medical.get(i).getNextLookAfter());// getNextLookAfter will return the next animal in the list
				}
				counter++;				
			}
		}
		dessign.totalFooter("Total: "+ counter+ "  into the company");
		dessign.footer();
	}
	
	// staff class has a list of animals assigned, this method will do that randomly 
	// as the medical class is the only type of staff looking after the animals, we are going to work in medical list only
	public void assignAnimals(AnimalFactory animals) {		
		Random rand = new Random();
		if(medical.size() == 0 || animals.getSize() == 0) {
			System.out.println("Please check animal factory and staff, both should not be empty");
		}		
		// setting animals to the staff
		for(int i=0; i < animals.getSize();i++) {			
			int j= rand.nextInt(medical.size());
			medical.get(j).setAnimal(animals.getAnimal(i));				
		}	
	}
	// printing all the medical staff with the animals assigned
	public void printStaffAnimals() {
		
		if(medical.size() == 0) {
			System.out.println("There are no staff in the company, please try again");
		}
		dessign.header("Vet Lovely Pet - Staff Animals assigned -");
		String animals;
		for(int i=0; i < medical.size(); i++) {
			if(medical.get(i).getNumberAnimals()!=0) {
				if(medical.get(i).getNumberAnimals()!=0)// if the list of animals belonging to the staff is not empty lets proceed getting the data
					animals=medical.get(i).getAnimals();
				else
					animals="No animals assigned";// is the list is empty, print this message
				String row = "   "+medical.get(i).getNumber()+dessign.spaces(String.valueOf(medical.get(i).getNumber()),6)+medical.get(i).getName()+dessign.spaces(medical.get(i).getName(),15)+medical.get(i).getSurname()+dessign.spaces(medical.get(i).getSurname(),15)+medical.get(i).getCategory()+dessign.spaces(medical.get(i).getCategory(),25)+animals;
				System.out.println(row);
			}			
		}
		dessign.totalFooter("Total Employees "+ medical.size());
		dessign.footer();
	}
	// getting the size of the general list
	public int getAllSize() {
		return staff.size();
	}
	// getting the size of the medical list only
	public int getSizeMedical() {
		return medical.size();
	}
	// getting the size of the admin list only
	public int getSizeAdmin() {
		return admin.size();
	}	
	
}
