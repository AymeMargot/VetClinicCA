package staff;

import java.util.Random;

import task.TaskInterface;
import taskFactory.TaskFactory;

public class Nutritionist extends Medical implements TaskInterface{

	public Nutritionist(int code, String name, String surname, Integer salary) {
		super(code, name, surname, salary);
		// After its being initialized, it will get the regarding task
		SetTasks();
	}
	
	@Override
	public void SetTasks(){
		TaskFactory Stafftasks = new TaskFactory();
		//it will produce task for Veterinarian only
		Stafftasks.produceTaskVeterinarian();
		int i=0;
		Random rand = new Random(); 
		while(i < 3) {
			int index = rand.nextInt(Stafftasks.getSize());			
			if(tasks.add(Stafftasks.getTask(index)))
				i++;
		}
	}

}
