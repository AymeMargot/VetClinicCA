package category;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;

public class Category {
	
	ArrayList<String>	categories;
	String namePackage;
	private Scanner input;
	
	public  Category(String namePackage) {			
		categories = new ArrayList<String>();
		this.namePackage = namePackage;			
	}
	
	public void process() {
		try {
			Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(namePackage);
			while (urls.hasMoreElements()) {
				URL url = urls.nextElement();
				File dir = new File(url.getFile());
				for (File f : dir.listFiles()) {
					String filename = new File(f.getPath()).getName();
					String classname = filename.substring(0,filename.length()-6);
					categories.add(classname);
				}//end for
			}// end while
		}
		catch(Exception e) {
			System.out.println("Something is going wrong, categories not processed");
		}
	}
	
	public int print() {		
		input = new Scanner(System.in);		
		if(categories.size() == 0) {
			System.out.println("Any category added, please try again");
			return -1;
		}
		else {
			System.out.println("\n");
			System.out.println("...................................................................................");
			System.out.println("Categories");
			System.out.println("...................................................................................");
			for(int i=0; i < categories.size();i++) {
				System.out.println(i+1+") "+categories.get(i));				
			}			
			System.out.println(categories.size()+1+") Back to the main menu");
			System.out.print("Select an option  ");
			try {
				int option = input.nextInt();
				if(option > 0 && (option <= categories.size()+1))
					return option-1;
				else {
					System.out.println("Invalid number, try again");
					return -2;
				}
			}
			catch(Exception e) {
				System.out.println("Invalid number, try again");
				return -2;
			}
		}
	}

	public int getSize() {
		return this.categories.size();
	}
	
	public String getName(int i) {
		return this.categories.get(i);
	}
}
