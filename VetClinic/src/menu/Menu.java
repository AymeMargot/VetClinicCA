
package menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Menu {
	
	 Map< Integer,String> items;
	 Scanner input = new Scanner(System.in);
	
	 public Menu(){
		
		 items = new HashMap< Integer,String>(); 
		
		 items.put(1,"List all Staff");
		 items.put(2,"List staff by categories (e.g. list all Nurses)");
		 items.put(3,"List all Admin staff performing a certain task");
		 items.put(4,"Search for a specific member of staff by name");
		 items.put(5,"List all animals");
		 items.put(6,"List animals by various types (e.g. list all dogs) ");
		 items.put(7,"Search for a specific animal by name");	
		 items.put(8,"List all the animals assigned to a member of medical staff");	
		 items.put(9,"List the order in which pets will be looked after by a particular member of the medical staff");	
		 items.put(10,"For a given member of the medical staff, pass to the next pet. ");	
		 items.put(11,"Exit");	
	}
	
	public int print() {
		
		Set <Map.Entry <Integer,String> > each = items.entrySet(); 
		
		int option;
		System.out.println("\n");
		System.out.println("...................................................................................");
		System.out.println("Vet My lovely pet  - System -");
		System.out.println("...................................................................................");
		for (Map.Entry <Integer,String> value:each){ 
			System.out.print(value.getKey()+".- "); 
	        System.out.println(value.getValue()); 
	    } 
		System.out.println("...................................................................................");
		System.out.print("Enter an option:  ");
		try {
			
			option = input.nextInt();
			if(option < 1 || option > items.size()){
				System.out.println("Invalid option try again");
				return -1;
			}			
			return option;
		}
		catch(Exception e) {
			System.out.println("Invalid option, try again");
			return -1;			
	    }
	}
	
	public int getExit() {
		return items.size();
	}
}
