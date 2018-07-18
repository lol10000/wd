package de.exxcellent.challenge;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    public static void main(String... args) {

        // Your preparation code …
    	
    	Scanner scan = new Scanner(System.in);
    	
    	System.out.println("Enter path of weather table");	
    	String path = scan.next();
    	
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
    	
    	Iterator<CSVRecord> iterator = records.iterator();
    	
    	iterator.next();
    	CSVRecord entry = iterator.next();
    	
    	String currentDay = entry.get(0);
    	int currentDifference = Math.abs(Integer.valueOf(entry.get(1)) - Integer.valueOf(entry.get(2))); 
    	
    	while (iterator.hasNext()) {
    		
    		entry = iterator.next();	
    		int value = Math.abs(Integer.valueOf(entry.get(1)) - Integer.valueOf(entry.get(2)));
    		
    		if (value > currentDifference) {
    			currentDay = entry.get(0);
    			currentDifference = value;
    		}
    		
    	}
    	
    	System.out.println("day: " + currentDay + ", difference: " + currentDifference);
    	
    	/*
    	String dayWithSmallestTempSpread = "Someday";     // Your day analysis function call …
        String teamWithSmallesGoalSpread = "A good team"; // Your goal analysis function call …

        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallesGoalSpread);
        */   
        
    }
}
