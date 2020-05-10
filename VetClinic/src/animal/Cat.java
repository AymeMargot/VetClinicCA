package animal;

public class Cat extends Animal {
	
	protected static int limitAge = 14;
	
	public Cat(int code, String name, int condition) {
		
		super(code, name, condition);
		this.age= this.randomAge.nextInt(limitAge);
		// TODO Auto-generated constructor stub
	}

}
