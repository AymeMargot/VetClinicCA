package animal;

public class Rabbit extends Animal {
	
	protected static int limitAge = 8;
	
	public Rabbit(int code, String name, int condition) {
		
		super(code, name, condition);
		this.age= this.randomAge.nextInt(limitAge);
		// TODO Auto-generated constructor stub
	}

}
