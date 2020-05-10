package taskFactory;

import java.util.LinkedList;
import java.util.Scanner;

import task.Task;

public class TaskFactory {
	
	protected LinkedList<Task> tasks;
	private Scanner input;
	
	public TaskFactory() {
		tasks = new LinkedList<Task>();		
	}
	
	public void produceTaskIt() {
		
		tasks.add(new Task(1,"Install and configure computer hardware, software, systems, networks, printers and scanners"));
		tasks.add(new Task(2,"Monitor and maintain computer systems and networks"));
		tasks.add(new Task(3,"Respond to service issues and requests"));
		tasks.add(new Task(4,"Provide technical support across the company"));
		tasks.add(new Task(5,"Set up accounts for new users"));
		tasks.add(new Task(6,"Repair and replacing equipment as necessary"));
		tasks.add(new Task(7,"Test new technology"));
		
	}	
	
	public void produceTaskReceptionist() {
		
		tasks.add(new Task(8,"Keeps a safe and clean reception area by complying procedures, rules, and regulations."));
		tasks.add(new Task(9,"Serves visitors by greeting, welcoming, and directing them appropriately"));
		tasks.add(new Task(10,"Notifies company personnel of visitor arrival"));
		tasks.add(new Task(11,"Making appointments"));
	}
	
	public void produceTaskManager() {
		
		tasks.add(new Task(12,"Monitor Staff"));
		tasks.add(new Task(13,"Disseminator"));
		tasks.add(new Task(14,"Resource Allocator"));
		tasks.add(new Task(15,"Negotiator "));
	}
	
	public void produceTaskAccount() {
		
		tasks.add(new Task(16,"Preparing accounts and tax returns"));
		tasks.add(new Task(17,"Administering payrolls and controlling income and expenditure."));
		tasks.add(new Task(18,"Auditing financial information"));
		tasks.add(new Task(19,"Compiling and presenting reports, budgets, business plans, commentaries and financial statements "));
		tasks.add(new Task(20,"Analysing accounts and business plans. "));
	}
	
	public void produceTaskVeterinarian() {
		
		tasks.add(new Task(21,"Examine animals to diagnose their health problems"));
		tasks.add(new Task(22,"Perform surgery on animals"));
		tasks.add(new Task(23,"Test for and vaccinate against diseases"));
		tasks.add(new Task(24,"Advise animal owners about general care, medical conditions, and treatments "));
		tasks.add(new Task(25,"Operate medical equipment, such as x-ray machines"));
	}
	
	public void produceTaskNurse() {
		
		tasks.add(new Task(26,"Feed animals and monitor whether they're eating"));
		tasks.add(new Task(27,"Bathe pets when necessary"));
		tasks.add(new Task(28,"Assist veterinarians and vet technicians with lab work"));
		tasks.add(new Task(29,"Clean, sterilize, and maintain kennels, operating rooms, examining rooms, cages, and surgical equipment "));
	}
	public String getTaskName(int code) {
		
		int i=0;
		while(i < tasks.size()) {
			if(tasks.get(i).getCode() == code)
				return tasks.get(i).getName();
			i++;
		}
		return "None";
	}
	
	public int getTaskCode(int index) {		
		return tasks.get(index).getCode();	
	}
	
	public int getSize() {
		return tasks.size();
	}
	
	
	public int print() {
		
		input = new Scanner(System.in);		
		if(tasks.size() == 0) {
			System.out.println("Any task added, please try again");
			return 0;
		}
		else {
			System.out.println("....................................................");
			System.out.println("Tasks");
			System.out.println("....................................................");
			for(int i=0; i < tasks.size();i++) {
				System.out.println(i+1+") "+tasks.get(i));				
			}			
			System.out.println(tasks.size()+1+") Back to the main menu");
			System.out.print("Select an option  ");
			try {
				int option = input.nextInt();
				if(option > 0 && option < tasks.size())
					return option-1;
				else {
					System.out.println("Invalid number, try again");
					return tasks.size();
				}
			}
			catch(Exception e) {
				System.out.println("Invalid number, try again");
				return tasks.size();
			}
		}
	}	
	
}
