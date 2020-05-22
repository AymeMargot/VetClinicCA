package general;
/*
 * ProcessCode is the class which generates code for animals and staff
 */
public class ProcessCode {
	protected int code;
	//constructor
	public ProcessCode() {
		code=0;
	}
	// Getting code, every time this method is invoke will be increased by one 
	public int getCode() {
		code=code+1;
		return code;
	}
}
