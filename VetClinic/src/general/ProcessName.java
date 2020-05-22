package general;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/*
 * ProcessName This class will generate names
 */
public class ProcessName {
	protected ArrayList<String> names;

	public ProcessName(int max,String pathFile) {
		
		names = new ArrayList<>();	
		int counter = 0;		
		String name;
		try {
		      //Defining a file object redirecting the path where is found a file with people names
			  File myObj = new File(pathFile);
		      Scanner myReader = new Scanner(myObj);
		      //as there are elements in the file and the counter is less than the limit number defined by the user
		      // the elements from the file will be added
		      
		      while (myReader.hasNextLine() && (counter < max)) {
		    	  name = myReader.nextLine();
		    	  // in order to have every name in the same format, every data will convert into a lower case with the
		    	  //first letter in Upper case
		    	  name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
		    	  // when ever the element is added the counter will increase
		    	if(this.names.add(name)) 
		    		counter++;		            
		      }
		      //once the list is full, the file will be closed
		      myReader.close();
		     
		      
		} catch(Exception e){
			System.out.println("Something is going Wrong, the name's list couldnt be generated");
			
		}		   
	}
	
	public int getSize() {
		return this.names.size();
	}
	
	public String getElem(int index) {
		 return this.names.get(index);
	}
	
	public String getName(int size) {
		
		Random random = new Random();
		return(names.get(random.nextInt(size)));
	}
}
