package animalFactory;
import java.util.LinkedList;
import animal.*;
import general.ProcessName;
import general.headerFooter;
import general.ProcessCode;
/*
 * AnimalFactory is a class with generate a list of animals, print them, search an specific animal between them
 * or simple classifying them by category
 * Attributes
 * animals: list of animals
 * nameGenerator: Class which generates random names
 * healthConditionsGenerator: Class which generates random medical condition
 * codeGenerator: Class with generate a unique code
 * pathFile: Variable which defines the path of the file.txt containing names
 * dessign : Class containing the format designing for footer or header on printing methods 
 */

public class AnimalFactory {
	
	protected LinkedList<Animal> animals;
	private static ProcessName nameGenerator;
	private static ProcessMedicalCondition healthConditionsGenerator;
	private static ProcessCode codeGenerator;
	private static String pathFile ="..\\VetClinic\\src\\animalFactory\\petnames.txt";	
	
	public headerFooter dessign = new headerFooter();
	
	//Constructor
	public AnimalFactory() {
		
		animals = new LinkedList<Animal>();
		nameGenerator = new ProcessName(90,pathFile); // the names will be pick up randomly between 90 names from the file.txt
		healthConditionsGenerator = new ProcessMedicalCondition();
		codeGenerator = new ProcessCode();
	}
	// get the entire size of the list animals
	public int getSize() {
		
		return animals.size();
	}
	// get an animal from a specific position i
	public Animal getAnimal(int i) {
		return animals.get(i);
	}
	// Method which produces animals an put them into the list, limit is the number of animals will be generated
	public void produceAnimals(int limit) {
		
		int counter=0;
		int num = 1;
		// counter is a variable which count the number of animals added on the list
		while(counter < limit) {
			//picking up a random name
			String name = nameGenerator.getName(nameGenerator.getSize());
			// picking up a random medical condition
			Condition condition = healthConditionsGenerator.getCondition();
			// generating a code
			int code = codeGenerator.getCode();
			// in order to generate different types of animals is being used switch, and num is the variable which
			// help to control which type of animals has to be created, once are created the 5 categories we have, it will
			// start again switching num=0;
			switch(num) {
			  case 1:
				if(animals.add(new Cat(code, name, condition))) 
					counter++;					
			    break;
			  case 2:
				if(animals.add(new Dog(code, name, condition))) 
					counter++;					
			    break;
			  case 3:
				if(animals.add(new Horse(code, name, condition)))
					counter++;
				break;
			  case 4:
				if(animals.add(new Parrot(code, name, condition)))
					counter++;
				break;
			  default:
				if(animals.add(new Rabbit(code, name, condition))) {
					counter++;
					num = 0;
				}
				break;
				
			}// end switch
			num++;		
		}// endWhile		
	}
	
	// Method which prints all the animals from the list
	public boolean printAnimals() {
		
		if(animals.size() == 0) {
			System.out.println("There are no animals in the factory, please try again");
			return false;
		}
		// printing the header
		dessign.headerAnimal("Vet Lovely Pet - List of animals -");		
		for(int i=0; i < animals.size(); i++) {
			String row = "   "+animals.get(i).getCode()+dessign.spaces(String.valueOf(animals.get(i).getCode()),6)+animals.get(i).getName()+dessign.spaces(animals.get(i).getName(),15)+animals.get(i).getCategory()+dessign.spaces(animals.get(i).getCategory(),15)+animals.get(i).getAge()+dessign.spaces(String.valueOf(animals.get(i).getAge()),6)+animals.get(i).getMedicalCondition().getName();
			System.out.println(row);
		}
		dessign.totalFooter("Total: "+animals.size());
		// printing the footer
		dessign.footer();		
		return true;
	}
	
	// Method which print the animals regarding to a specific category
	public boolean printAnimalsByCategory(String category) {
		
		if(animals.size() == 0) {
			System.out.println("No animals into the factory, please check it");
			return false;
		}
		// variable which counts the number of incidences found in the list
		int counter = 0;	
		// printing header with category title
		dessign.headerAnimal("Animals "+ category);
		for(int i=0; i < animals.size(); i++) {
			// whenever the animal belongs to the category we are looking for, the animal will be printed
			if(category.equals(animals.get(i).getCategory())) {
				// Getting the data from the animal will be printed, the spaces method will add the spaces between them making a symmetrical columns
				String row = "   "+animals.get(i).getCode()+dessign.spaces(String.valueOf(animals.get(i).getCode()),6)+animals.get(i).getName()+dessign.spaces(animals.get(i).getName(),15)+animals.get(i).getCategory()+dessign.spaces(animals.get(i).getCategory(),15)+animals.get(i).getAge()+dessign.spaces(String.valueOf(animals.get(i).getAge()),6)+animals.get(i).getMedicalCondition().getName();
				System.out.println(row);
				counter++;
			}
		}
		dessign.totalFooter("Total: "+ counter+ "  into the factory");
		// printing footer
		dessign.footer();
		return true;
	}
	
	// Method searching animals by name
	public void searchAnimalByName(String name) {
		if(animals.size() == 0) {
			System.out.println("No animals into the factory, please check it");
		}
		int counter = 0;	
		// printing header
		dessign.headerAnimal("Searching  "+ name);		
		for(int i=0; i < animals.size(); i++) {
			// comparing animal names with the data entered
			if(name.toLowerCase().equals(animals.get(i).getName().toLowerCase())) {
				// Getting the data from the animal will be printed, the spaces method will add the spaces between them making a symmetrical columns
				String row = "   "+animals.get(i).getCode()+dessign.spaces(String.valueOf(animals.get(i).getCode()),6)+animals.get(i).getName()+dessign.spaces(animals.get(i).getName(),15)+animals.get(i).getCategory()+dessign.spaces(animals.get(i).getCategory(),15)+animals.get(i).getAge()+dessign.spaces(String.valueOf(animals.get(i).getAge()),6)+animals.get(i).getMedicalCondition().getName();
				System.out.println(row);
				counter++;
			}
		}
		dessign.totalFooter("Total: "+ counter+ "  into the factory");
		// printing footer
		dessign.footer();
	}
}
