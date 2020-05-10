package animalFactory;
import java.util.LinkedList;
import animal.*;
import general.ProcessName;
import general.ProcessCode;


public class AnimalFactory {
	
	protected LinkedList<Animal> animals;
	private static ProcessName nameGenerator;
	private static ProcessMedicalCondition healthConditionsGenerator;
	private static ProcessCode codeGenerator;
	private static String pathFile ="C:\\JavaProyect\\VetClinic\\src\\animalFactory\\petnames.txt";	
	
	public AnimalFactory() {
		
		animals = new LinkedList<Animal>();
		nameGenerator = new ProcessName(90,pathFile);
		healthConditionsGenerator = new ProcessMedicalCondition();
		codeGenerator = new ProcessCode();
	}
	
	public int getSize() {
		
		return animals.size();
	}
	
	public Animal getAnimal(int i) {
		return animals.get(i);
	}
	public void produceAnimals(int limit) {
		
		int counter=0;
		int num = 1;
	
		while(counter < limit) {
			
			String name = nameGenerator.getName(nameGenerator.getSize());
			int condition = healthConditionsGenerator.getCondition();
			int code = codeGenerator.getCode();
					
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
			animals.get(animals.size()-1).setPriorityLookAfter(animals.size()-1);
			num++;		
		}// endWhile		
	}
	
	public boolean printAnimals() {
		
		if(animals.size() == 0) {
			System.out.println("There are no animals in the factory, please try again");
			return false;
		}
		
		for(int i=0; i < animals.size(); i++) {
			System.out.println(animals.get(i));
		}
		return true;
	}
	
	public boolean printAnimalsByCategory(String category) {
		
		if(animals.size() == 0) {
			System.out.println("No animals into the factory, please check it");
			return false;
		}
		int counter = 0;
		System.out.println("....................................................");
		System.out.println("Animals "+ category);
		System.out.println("....................................................");
		for(int i=0; i < animals.size(); i++) {
			if(category.equals(animals.get(i).getCategory())) {
				System.out.println(animals.get(i));
				counter++;
			}
		}
		System.out.println("....................................................");
		System.out.println("Total: "+ counter+ "  into the factory");
		return true;
	}
	
	public boolean searchAnimalByName(String name) {
		if(animals.size() == 0) {
			System.out.println("No animals into the factory, please check it");
			return false;
		}
		int counter = 0;
		System.out.println("....................................................");
		System.out.println("Searching  "+ name);
		System.out.println("....................................................");
		for(int i=0; i < animals.size(); i++) {
			if(name.equals(animals.get(i).getName())) {
				System.out.println(animals.get(i));
				counter++;
			}
		}
		System.out.println("....................................................");
		System.out.println("Total: "+ counter+ "  into the factory");
		return true;
	}
	
}
