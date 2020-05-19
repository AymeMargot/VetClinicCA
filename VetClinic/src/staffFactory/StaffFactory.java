package staffFactory;

import java.util.LinkedList;
import java.util.Random;

import animalFactory.AnimalFactory;
import general.ProcessCode;
import general.ProcessName;
import staff.*;
import task.Task;
import taskFactory.TaskFactory;


public class StaffFactory {
	
	protected LinkedList<Staff> staff;
	protected LinkedList<Staff> admin;
	protected LinkedList<Staff> medical;
	
	private static ProcessName nameGenerator;
	private static ProcessName surnameGenerator;
	private static ProcessCode codeGenerator;
	private static String pathFileName ="..\\VetClinic\\src\\staffFactory\\names.txt";	
	private static String pathFileSurname ="..\\VetClinic\\src\\staffFactory\\surnames.txt";
	
	public StaffFactory() {
		
		staff = new LinkedList<Staff>();
		admin = new LinkedList<Staff>();
		medical = new LinkedList<Staff>();
		
		nameGenerator = new ProcessName(90,pathFileName);
		surnameGenerator = new ProcessName(90,pathFileSurname);		
		codeGenerator = new ProcessCode();
	}
	
	public void produceStaffAdmin(int limit) {
		
		int counter=0;
		int num = 1;	
			
		while(counter < limit) {
			
			String name = nameGenerator.getName(nameGenerator.getSize());
			String surname = surnameGenerator.getName(surnameGenerator.getSize());
			int code = codeGenerator.getCode();	
			
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
	
	
	public void printStaff() {
		
		if(staff.size() == 0) {
			System.out.println("There are no staff in the company, please try again");
		}
				
		System.out.println("Vet Lovely Pet - List of employees -");
		System.out.println("...................................................................................");
		System.out.println(" CODE	 NAME	        SURNAME   	POSITION");
		System.out.println("...................................................................................");
		for(int i=0; i < staff.size(); i++) {
			String row = "   "+staff.get(i).getNumber()+spaces(String.valueOf(staff.get(i).getNumber()),6)+staff.get(i).getName()+spaces(staff.get(i).getName(),15)+staff.get(i).getSurname()+spaces(staff.get(i).getSurname(),15)+staff.get(i).getCategory();
			System.out.println(row);
		}
		System.out.println("...................................................................................");
		System.out.println("Total Employees "+ staff.size());
	}
	
	public boolean printAdminStaff() {
		
		if(admin.size() == 0) {
			System.out.println("There are no staff Admin in the company, please try again");
			return false;
		}
		
		for(int i=0; i < admin.size(); i++) {
			System.out.println(admin.get(i));
		}
		return true;
	}
	
	public boolean printMedicalStaff() {
		
		if(medical.size() == 0) {
			System.out.println("There are no medical staff in the company, please try again");
			return false;
		}
		
		for(int i=0; i < medical.size(); i++) {
			System.out.println(medical.get(i) + medical.get(i).getAnimals());
		}
		return true;
	}
	
	public boolean printStaffByCategory(String category) {
		
		if(staff.size() == 0) {
			System.out.println("No staff into the company, please check it");
			return false;
		}
		int counter = 0;
		System.out.println("...................................................................................");
		System.out.println("Staff "+ category);
		System.out.println("...................................................................................");
		for(int i=0; i < staff.size(); i++) {
			if(category.equals(staff.get(i).getCategory())) {
				System.out.println(staff.get(i));
				counter++;
			}
		}
		System.out.println("...................................................................................");
		System.out.println("Total: "+ counter+ "  into the company");
		return true;
	}
	
	public boolean printStaffByTask(Task task, TaskFactory tasks) {
		
		if(staff.size() == 0) {
			System.out.println("No staff into the company, please check it");
			return false;
		}
		int counter = 0;
		System.out.println("....................................................");
		System.out.println("Task (Code: "+ task.getCode() +")  "+ task.getName());
		System.out.println("....................................................");
		for(int i=0; i < staff.size(); i++) {
			if(staff.get(i).isContained(task)) {
				System.out.println(staff.get(i));
				System.out.println(staff.get(i).getTasks());
				counter++;
			}
		}
		System.out.println("....................................................");
		System.out.println("Total: "+ counter+ "  into the company");
		return true;
	}
	
	public void searchStaffByName(String name) {
		if(staff.size() == 0) {
			System.out.println("No Staff into the company, please check it");
		}
		int counter = 0;
		System.out.println("....................................................");
		System.out.println("Searching  "+ name);
		System.out.println("....................................................");
		for(int i=0; i < staff.size(); i++) {
			if(name.toLowerCase().equals(staff.get(i).getName().toLowerCase())) {
				System.out.println(staff.get(i));
				counter++;
			}
		}
		System.out.println("....................................................");
		System.out.println("Total: "+ counter+ "  into the company");	
	}
	
	public void searchStaffByMedic(String name) {
		if(medical.size() == 0) {
			System.out.println("No Staff Medical into the company, please check it");
		}
		int counter = 0;
		System.out.println(".....................................................................");
		System.out.println("Searching  "+ name);
		System.out.println(".....................................................................");
		for(int i=0; i < medical.size(); i++) {
			if(name.toLowerCase().equals(medical.get(i).getName().toLowerCase()) && medical.get(i).getNumberAnimals()!=0) {
				System.out.println(medical.get(i));
				medical.get(i).orderAnimals();
				counter++;
			}
		}
		System.out.println(".....................................................................");
		System.out.println("Total: "+ counter+ "  into the company");
	}
	
	public void searchStaffByLookAfter(String name) {
		if(medical.size() == 0) {
			System.out.println("No Staff Medical into the company, please check it");
		}
		int counter = 0;
		System.out.println(".....................................................................");
		System.out.println("Searching  "+ name);
		System.out.println(".....................................................................");
		
		for(int i=0; i < medical.size(); i++) {
			if(name.toLowerCase().equals(medical.get(i).getName().toLowerCase()) && medical.get(i).getNumberlookAfter()!=0) {
				if(medical.get(i).assignAnimals()) {
					
					medical.get(i).orderAnimals();
					System.out.println(medical.get(i));
					System.out.println(medical.get(i).getTopLookAfter()+ "is the first to look after");
					System.out.println(medical.get(i).getNextLookAfter()+ "is the next to look after");
					counter++;
				}
				else
					System.out.println("Animals no assigned to this staff, try choosing option 8");
			}
		}
		System.out.println("....................................................................");
		System.out.println("Total: "+ counter+ "  into the company");
	}
	
	public int getAllSize() {
		return staff.size();
	}
	
	public int getSizeMedical() {
		return medical.size();
	}
	
	public int getSizeAdmin() {
		return admin.size();
	}
	
	public void assignAnimals(AnimalFactory animals) {		
		Random rand = new Random();
		if(medical.size() == 0 || animals.getSize() == 0) {
			System.out.println("Please check animal factory and staff, both should not be empty");
		}		
		
		for(int i=0; i < animals.getSize();i++) {
			
			int j= rand.nextInt(medical.size());
			medical.get(j).setAnimal(animals.getAnimal(i));				
		}	
	}
	
	public void printStaffAnimals() {
		
		if(staff.size() == 0) {
			System.out.println("There are no staff in the company, please try again");
		}
		System.out.println("......................................................................");
		System.out.println("Vet Lovely Pet - Staff Animals assigned -");
		System.out.println("......................................................................");
		for(int i=0; i < staff.size(); i++) {
			if(staff.get(i).getNumberAnimals()!=0) {
				System.out.println(staff.get(i));
				System.out.println("- "+staff.get(i).getAnimals());
			}			
		}
		System.out.println("......................................................................");
		System.out.println("Total Employees "+ staff.size());
	}
	
	//***************************************************************
	public String spaces(String word, int limit){
		int sizeWord = word.length();
		int n = limit -sizeWord;
		String str="";
		int i=0;
		while(i<n) {
			 str += " ";
			i++;
		}
       return str;
	} 
}
