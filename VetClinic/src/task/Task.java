package task;
/*
 * Task is a class which represents every task into the list factory
 * Attributes
 * code: the task code
 * name: the task name
 */
public class Task {
	
	protected int code;
	protected String name;
	// constructor
	public Task(int code,String name) {
		this.code = code;
		this.name= name;	
	}
	//constructor
	public Task() {
		this.name= "";
		this.code =0;
	}
	// getters and setters methods
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString(){ 
		 // return "[("+code+"), "+name+")]";  
		return name;
	}  

}