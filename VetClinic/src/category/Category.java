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
	
	public boolean process() {
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
			return false;
		}
		return true;
	}
	
	public int print() {		
		input = new Scanner(System.in);		
		if(categories.size() == 0) {
			System.out.println("Any category added, please try again");
			return 0;
		}
		else {
			System.out.println("....................................................");
			System.out.println("Categories");
			System.out.println("....................................................");
			for(int i=1; i < categories.size();i++) {
				System.out.println(i+") "+categories.get(i));				
			}			
			System.out.println(categories.size()+") Back to the main menu");
			System.out.print("Select an option  ");
			try {
				int option = input.nextInt();
				if(option > 0 && option < categories.size())
					return option;
				else {
					System.out.println("Invalid number, try again");
					return categories.size();
				}
			}
			catch(Exception e) {
				System.out.println("Invalid number, try again");
				return categories.size();
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
