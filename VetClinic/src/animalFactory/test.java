package animalFactory;

import category.Category;
import staffFactory.StaffFactory;
import taskFactory.TaskFactory;

public class test {

	
	
	public static void main(String[] args) {
		
		AnimalFactory factory = new AnimalFactory();
		
		StaffFactory staff = new StaffFactory();
				
		Category animalsCategory = new Category("animal");
		Category staffCategory = new Category("staff");
		TaskFactory tasks = new TaskFactory();
			
		factory.produceAnimals(500);
		factory.printAnimals();
		
	//	if(factory.searchAnimalByName("Bubba"))
			System.out.println("ok");		
		
		staff.produceStaffAdmin(10);
		staff.produceStaffMedical(30);
		
	//	staff.printMedicalStaff();
	/*	if(animalsCategory.process()) {			
			int option = animalsCategory.print();
			if(option < animalsCategory.getSize()) {
				String category = animalsCategory.getName(option);
				factory.printAnimalsByCategory(category);
			}		
		}
		
	
		if(staffCategory.process()) {			
			int option = staffCategory.print();
			if(option < staffCategory.getSize()) {
				String category = staffCategory.getName(option);
				staff.printStaffByCategory(category);
			}		
		}
		
		if(staff.searchStaffByName("Camila"))
			System.out.println("ok");
		
		tasks.produceTaskIt();
		tasks.produceTaskAccount();
		tasks.produceTaskVeterinarian();
		tasks.produceTaskNurse();
		tasks.produceTaskManager();
		tasks.produceTaskReceptionist();
		int option = tasks.print();
		if(option < tasks.getSize()) {
			int code = tasks.getTaskCode(option);
			staff.printStaffByTask(code,tasks);
		}
	*/	
		//if(staff.assignAnimals(factory)) {
			staff.printMedicalStaff();
	//	}
		
		//if(staff.searchStaffByMedic("Amelia")) {
			System.out.println("ok");
		//}
	}

}
