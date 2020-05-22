package general;

public class headerFooter {
	public headerFooter() {
		
	}

	public String spaces(String word, int limit){
		int sizeWord = word.length();
		int n = limit -sizeWord;
		String str="";
		int i=0;
		while(i<n) {
			 str += " ";
			i++;
		}
       return str;
	} 
	
	public void header(String title) {
		System.out.println("\n");
		System.out.println(title);
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(" CODE	 NAME	        SURNAME   	POSITION");
		System.out.println("===================================================================================");
		
	}
	
	public void headerAnimal(String title) {
		System.out.println("\n");
		System.out.println(title);
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(" CODE	 NAME	      CATEGORY       AGE	   MEDICAL CONDITION");
		System.out.println("===================================================================================");
		
	}
	
	public void header2(String title) {
		System.out.println("\n");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(title);
		System.out.println("===================================================================================");
		
	}
	
	public void header3(String title) {
		System.out.println("\n");
		System.out.println(title);
		System.out.println("-----------------------------------------------------------------------------------");		
	}
	
	public void header4(String title) {
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(title);
		System.out.println("===================================================================================");
		
	}
	public void footer() {
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("\n");
	}
	
	public void footer1() {
		System.out.println("-----------------------------------------------------------------------------------");
	}
	
	public void totalFooter(String total) {
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(total);
		
	}
}
