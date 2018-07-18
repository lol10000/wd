package de.exxcellent.table;

public class TableAnalysis {
	
	public static Result determineSolution(String[][] table, String label0, String label1) {
		
		int number0 = 0;
		int number1 = 0;
		
		for (int i = 0; i < table[0].length; i++) {
			if (table[0][i].equals(label0)) {
				number0 = i;
			}
			
			if (table[0][i].equals(label1)) {
				number1 = i;
			}
		}
		
    	String currentName = table[1][0];
    	int currentDifference = Math.abs(Integer.valueOf(table[1][1]) - Integer.valueOf(table[1][2])); 
    	
    	for (int i = 2; i < table.length; i++) {
    		
    		String[] entry = table[i];	
    		int value = Math.abs(Integer.valueOf(entry[number0]) - Integer.valueOf(entry[number1]));
    		
    		if (value < currentDifference) {
    			currentName = entry[0];
    			currentDifference = value;
    		}	
    	}
    	
    	Result r = new Result();
    	
    	r.setName(currentName);
    	r.setValue(currentDifference);
    	
    	return r;
	}
}
