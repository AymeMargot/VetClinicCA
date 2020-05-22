package staff;

import java.util.Random;

import task.TaskInterface;
import taskFactory.TaskFactory;

public class Manager extends Administration implements TaskInterface{

	public Manager(int code, String name, String surname, Integer salary) {
		super(code, name, surname, salary);
		// After its being initialized, it will get the regarding task
		this.SetTasks();
	}
	
	@Override
	public void SetTasks(){
		TaskFactory Stafftasks = new TaskFactory();
		//it will produce task for Manager only
		Stafftasks.produceTaskManager();
		int i=0;
		Random rand = new Random(); // get a random task
		while(i < 3) {
			int index = rand.nextInt(Stafftasks.getSize());			
			if(tasks.add(Stafftasks.getTask(index))) //assigning a task
				i++;
		}
	}

}
