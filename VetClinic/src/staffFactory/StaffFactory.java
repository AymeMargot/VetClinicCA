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
		dessign.header("Vet Lovely Pet - List of employees -");			
		for(int i=0; i < staff.size(); i++) {
			String row = "   "+staff.get(i).getNumber()+dessign.spaces(String.valueOf(staff.get(i).getNumber()),6)+staff.get(i).getName()+dessign.spaces(staff.get(i).getName(),15)+staff.get(i).getSurname()+dessign.spaces(staff.get(i).getSurname(),15)+staff.get(i).getCategory();
			System.out.println(row);
		}
		dessign.totalFooter("Total Employees "+ staff.size());
		dessign.footer();
	}
	
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
	
	public boolean printStaffByCategory(String category) {
		
		if(staff.size() == 0) {
			System.out.println("No staff into the company, please check it");
			return false;
		}
		int counter = 0;
		dessign.header("Staff "+ category);
		for(int i=0; i < staff.size(); i++) {
			if(category.equals(staff.get(i).getCategory())) {
				String row = "   "+staff.get(i).getNumber()+dessign.spaces(String.valueOf(staff.get(i).getNumber()),6)+staff.get(i).getName()+dessign.spaces(staff.get(i).getName(),15)+staff.get(i).getSurname()+dessign.spaces(staff.get(i).getSurname(),15)+staff.get(i).getCategory();
				System.out.println(row);
				counter++;
			}
		}
		dessign.totalFooter("Total: "+ counter+ "  into the company");
		dessign.footer();
		return true;
	}
	
	public boolean printStaffByTask(Task task, TaskFactory tasks) {
		
		if(staff.size() == 0) {
			System.out.println("No staff into the company, please check it");
			return false;
		}
		int counter = 0;
		dessign.header("Task (Code: "+ task.getCode() +")  "+ task.getName());
		for(int i=0; i < staff.size(); i++) {
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
					System.out.println("ROUND FOR CARING "+medical.get(i).getTopLookAfter());
					System.out.println("NEXT  FOR CARING "+medical.get(i).getNextLookAfter());
				}
				counter++;				
			}
		}
		dessign.totalFooter("Total: "+ counter+ "  into the company");
		dessign.footer();
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
		
		if(medical.size() == 0) {
			System.out.println("There are no staff in the company, please try again");
		}
		dessign.header("Vet Lovely Pet - Staff Animals assigned -");
		String animals;
		for(int i=0; i < medical.size(); i++) {
			if(medical.get(i).getNumberAnimals()!=0) {
				if(medical.get(i).getNumberAnimals()!=0)
					animals=medical.get(i).getAnimals();
				else
					animals="No animals assigned";
				String row = "   "+medical.get(i).getNumber()+dessign.spaces(String.valueOf(medical.get(i).getNumber()),6)+medical.get(i).getName()+dessign.spaces(medical.get(i).getName(),15)+medical.get(i).getSurname()+dessign.spaces(medical.get(i).getSurname(),15)+medical.get(i).getCategory()+dessign.spaces(medical.get(i).getCategory(),25)+animals;
				System.out.println(row);
			}			
		}
		dessign.totalFooter("Total Employees "+ medical.size());
		dessign.footer();
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
	
}
