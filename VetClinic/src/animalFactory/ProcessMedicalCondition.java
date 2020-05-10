package animalFactory;

import java.util.ArrayList;
import java.util.Random;

public class ProcessMedicalCondition {
	protected ArrayList<Condition> healthConditions;
	static Random random = new Random();
	
	public ProcessMedicalCondition() {
		
		healthConditions = new ArrayList<Condition>();
		
		healthConditions.add(new Condition(1,"Allergies"));
		healthConditions.add(new Condition(2,"Infection"));
		healthConditions.add(new Condition(3,"Arthritis"));
		healthConditions.add(new Condition(4,"Vomiting/Upset Stomach"));
		healthConditions.add(new Condition(5,"Periodontitis/Dental Disease"));
		healthConditions.add(new Condition(6,"Diarrhea/ Intestinal Upset"));
		healthConditions.add(new Condition(7,"Bladder or Urinary Tract Infection"));
		healthConditions.add(new Condition(8,"Bruise"));
		healthConditions.add(new Condition(9,"Bladder or Urinary Tract Disease"));
		healthConditions.add(new Condition(10,"Periodontitis/Dental Disease"));
		healthConditions.add(new Condition(11,"Chronic Kidney Disease"));
		healthConditions.add(new Condition(12,"Diabetes"));
		healthConditions.add(new Condition(13,"Inflammatory Bowel Disease"));
		healthConditions.add(new Condition(14,"Upper Respiratory Infection"));
		healthConditions.add(new Condition(15,"Broken bones"));
		healthConditions.add(new Condition(16,"Lymphoma"));
	}
	
	
	public int getCondition() {
		
		Condition aux = healthConditions.get(random.nextInt(healthConditions.size()));
		return(aux.getCode());
	}
	
	public String getCondition(int code) {	
		
		boolean find = false;
		int i = 0;
		while(!find && i < healthConditions.size()) {
			if(healthConditions.get(i).getCode() == code)
				return healthConditions.get(i).getName();
			i++;
		}
		return "No name Medical Condition";
	}
}
