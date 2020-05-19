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
	private static String pathFile ="..\\VetClinic\\src\\animalFactory\\petnames.txt";	
	
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
			Condition condition = healthConditionsGenerator.getCondition();
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
			num++;		
		}// endWhile		
	}
	
	public boolean printAnimals() {
		
		if(animals.size() == 0) {
			System.out.println("There are no animals in the factory, please try again");
			return false;
		}		
		header("Vet Lovely Pet - List of animals -");		
		for(int i=0; i < animals.size(); i++) {
			String row = "   "+animals.get(i).getCode()+spaces(String.valueOf(animals.get(i).getCode()),6)+animals.get(i).getName()+spaces(animals.get(i).getName(),15)+animals.get(i).getCategory()+spaces(animals.get(i).getCategory(),15)+animals.get(i).getAge()+spaces(String.valueOf(animals.get(i).getAge()),6)+animals.get(i).getMedicalCondition().getName();
			System.out.println(row);
		}
		totalFooter("Total: "+animals.size());
		footer();		
		return true;
	}
	
	public boolean printAnimalsByCategory(String category) {
		
		if(animals.size() == 0) {
			System.out.println("No animals into the factory, please check it");
			return false;
		}
		int counter = 0;		
		header("Animals "+ category);
		for(int i=0; i < animals.size(); i++) {
			if(category.equals(animals.get(i).getCategory())) {
				String row = "   "+animals.get(i).getCode()+spaces(String.valueOf(animals.get(i).getCode()),6)+animals.get(i).getName()+spaces(animals.get(i).getName(),15)+animals.get(i).getCategory()+spaces(animals.get(i).getCategory(),15)+animals.get(i).getAge()+spaces(String.valueOf(animals.get(i).getAge()),6)+animals.get(i).getMedicalCondition().getName();
				System.out.println(row);
				counter++;
			}
		}
		totalFooter("Total: "+ counter+ "  into the factory");	
		footer();
		return true;
	}
	
	public void searchAnimalByName(String name) {
		if(animals.size() == 0) {
			System.out.println("No animals into the factory, please check it");
		}
		int counter = 0;	
		header("Searching  "+ name);		
		for(int i=0; i < animals.size(); i++) {
			if(name.toLowerCase().equals(animals.get(i).getName().toLowerCase())) {
				String row = "   "+animals.get(i).getCode()+spaces(String.valueOf(animals.get(i).getCode()),6)+animals.get(i).getName()+spaces(animals.get(i).getName(),15)+animals.get(i).getCategory()+spaces(animals.get(i).getCategory(),15)+animals.get(i).getAge()+spaces(String.valueOf(animals.get(i).getAge()),6)+animals.get(i).getMedicalCondition().getName();
				System.out.println(row);
				counter++;
			}
		}
		totalFooter("Total: "+ counter+ "  into the factory");
		footer();
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
		
		private void header(String title) {
			System.out.println("\n");
			System.out.println(title);
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println(" CODE	 NAME	        CATEGORY    AGE     MEDICAL CONDITION ");
			System.out.println("===================================================================================");
			
		}
		
		private void footer() {
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println("\n");
		}
		
		private void totalFooter(String total) {
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println(total);
			
		}
	
}
