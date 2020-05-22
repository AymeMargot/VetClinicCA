package staff;

import java.util.Random;
import task.TaskInterface;
import taskFactory.TaskFactory;

public class ItNerd extends Administration implements TaskInterface{

	public ItNerd(int code,String name, String surname,Integer salary) {
		super(code,name, surname,salary);
		// After its being initialized, it will get the regarding task
		this.SetTasks();

	}

	@Override
	public void SetTasks(){
		TaskFactory Stafftasks = new TaskFactory();
		//it will produce task for ItNerd only
		Stafftasks.produceTaskIt();
		int i=0;
		Random rand = new Random(); // get a random task 
		while(i < 3) {
			int index = rand.nextInt(Stafftasks.getSize());			
			if(tasks.add(Stafftasks.getTask(index)))//assigning a task
				i++;
		}
	}	
	
}
