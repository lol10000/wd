package de.exxcellent.table;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class CSVReader implements TableReader {
	
	public static String[][] readTable(String path) {
		
    	Reader in = null;
    	
    	try {
			in = new FileReader(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	Iterable<CSVRecord> records = null;
    	
    	try {
			records = CSVFormat.EXCEL.parse(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	LinkedList<CSVRecord> temp = new LinkedList<CSVRecord>();
    	for (CSVRecord record : records) {
    		temp.add(record);	
    	}
    	
    	int rowNumber = temp.size();
    	int columnNumber = temp.get(0).size();
    	
    	String[][] result = new String[rowNumber][columnNumber];
    	for (int i = 0; i < rowNumber; i++) {
    		for (int j = 0; j < columnNumber; j++) {
    			result[i][j] = temp.get(i).get(j);
    		}
    	}
    	
		return result;
	}
}
