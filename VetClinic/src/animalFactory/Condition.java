package animalFactory;

public class Condition {
	protected int code;
	protected String name;
	
	
	public Condition(int code, String name) {
		this.code = code;
		this.name = name;
	}
	
	protected int getCode() {
		return code;
	}
	
	protected void setCode(int code) {
		this.code = code;
	}
	
	protected String getName() {
		return name;
	}
	
	protected void setName(String name) {
		this.name = name;
	}
	
	
}
