package client;

import menu.Menu;

public class main {
	
	Menu menu;
	
	public main() {
		menu = new Menu();
		
	}
	
	public void run() {
		int option=0;
		do {
			option = menu.print();
			
			switch(option) {
			  case 1:
			    System.out.print(menu.getExit());
			    break;
			  case 2:
			    // code block
			    break;
			  default:
			    // code block
			}			
			
		}while(option != menu.getExit());
	}
	
	public static void main(String[] args) {
	
		main system= new main();
		
		system.run();

	}

}
