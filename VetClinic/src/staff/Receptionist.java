package staff;

import java.util.Random;
import task.TaskInterface;
import taskFactory.TaskFactory;

public class Receptionist extends Administration implements TaskInterface {

	public Receptionist(int code,String name, String surname,Integer salary) {
		super(code,name, surname,salary);
		this.SetTasks();
	}


	@Override
	public void SetTasks(){
		TaskFactory Stafftasks = new TaskFactory();
		Stafftasks.produceTaskReceptionist();;
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
