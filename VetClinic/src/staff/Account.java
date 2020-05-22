package staff;

import java.util.Random;

import task.TaskInterface;
import taskFactory.TaskFactory;

public class Account extends Administration implements TaskInterface {
	// construct
	public Account(int code, String name, String surname, Integer salary) {
		super(code, name, surname, salary);
		// After its being initialized, it will get the regarding task
		SetTasks();
	}
	
	@Override
	public void SetTasks(){
		TaskFactory Stafftasks = new TaskFactory();
		//it will produce task for Accounts only
		Stafftasks.produceTaskAccount();
		int i=0;
		Random rand = new Random();// get a random task 
		while(i < 3) {
			int index = rand.nextInt(Stafftasks.getSize());			
			if(tasks.add(Stafftasks.getTask(index))) //assigning a task
				i++;
		}
	}

}
