package staff;

import java.util.Random;

import task.TaskInterface;
import taskFactory.TaskFactory;

public class Nurse extends Medical implements TaskInterface {

	public Nurse(int code,String name, String surname,Integer salary) {
		super(code,name, surname,salary);
		SetTasks();
	}
	
	@Override
	public void SetTasks(){
		TaskFactory Stafftasks = new TaskFactory();
		Stafftasks.produceTaskNurse();;
		int i=0;
		Random rand = new Random(); 
		while(i < 3) {
			int aux = rand.nextInt(Stafftasks.getSize());
			int task = Stafftasks.getTaskCode(aux);
			if(tasks.add(task))
				i++;
		}
	}

}
