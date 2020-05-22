package category;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;

import general.headerFooter;
/*
 * Category This class with get the classes name from a specific package
 * the animal and staff package contains the category types for each one, the were separated for this purpose only
 * Attributes
 * categories: this list will store the names of the files into a specific package
 * namePackage: name of the package
 * input: the variable which let the user choose one category before print
 *  dessign : Class containing the format designing for footer or header on printing methods
 */
public class Category {
	
	ArrayList<String>	categories;
	String namePackage;
	private Scanner input;
	public headerFooter dessign = new headerFooter();
	// Constructor
	public  Category(String namePackage) {			
		categories = new ArrayList<String>();
		this.namePackage = namePackage;			
	}
	//Method which get the file names of the package
	public void process() {
		try {
			Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(namePackage);
			while (urls.hasMoreElements()) { // catch the names of the file url
				URL url = urls.nextElement(); // picking up name by name
				File dir = new File(url.getFile());
				for (File f : dir.listFiles()) {
					String filename = new File(f.getPath()).getName();
					String classname = filename.substring(0,filename.length()-6); // separating the file name
					categories.add(classname); // Adding the name into the list
				}//end for
			}// end while
		}
		catch(Exception e) {
			System.out.println("Something is going wrong, categories not processed");
		}
	}
	// Method printing the names from the category list 
	public int print() {		
		input = new Scanner(System.in);		
		if(categories.size() == 0) {
			System.out.println("Any category added, please try again");
			return -1;
		}
		else {
			// printing header
			dessign.header4("CATEGORIES");
			for(int i=0; i < categories.size();i++) {
				System.out.println(i+1+") "+categories.get(i));				
			}
			dessign.header3(categories.size()+1+") Back to the main menu");	
			// Asking the user select an specific category
			System.out.print("Select an option  ");
			try {
				int option = input.nextInt();
				if(option > 0 && (option <= categories.size()+1))
					return option-1; // if the user select a correct option return option-1 because the list starts on 0 position
				else {
					System.out.println("Invalid number, try again");
					return -2; // for a invalid number will return -2
				}
			}
			catch(Exception e) {
				System.out.println("Invalid number, try again");
				return -2; // if the user enters a character instead of a number the function will return -2
			}
		}
	}
	// getting the size of the category list
	public int getSize() {
		return this.categories.size();
	}
	// getting the name of the category in a specific position
	public String getName(int i) {
		return this.categories.get(i);
	}
}
