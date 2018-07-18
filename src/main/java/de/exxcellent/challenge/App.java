package de.exxcellent.challenge;

import java.io.File;
import java.util.Scanner;

import de.exxcellent.table.CSVReader;
import de.exxcellent.table.Result;
import de.exxcellent.table.TableAnalysis;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    public static void main(String... args) {
    	
    	System.out.println("weather table");	
    	
    	String path = new File("").getAbsolutePath().concat("//src//main//resources//de//exxcellent//challenge//weather.csv");
    	
    	String[][] table = CSVReader.readTable(path);
    	Result r = TableAnalysis.determineSolution(table, "MxT", "MnT");

    	String dayWithSmallestTempSpread = r.getName();
    	System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        
    	System.out.println("football table");    	

    	path = new File("").getAbsolutePath().concat("//src//main//resources//de//exxcellent//challenge//football.csv");
    	
    	table = CSVReader.readTable(path);
    	r = TableAnalysis.determineSolution(table, "Goals", "Goals Allowed");
        
        String teamWithSmallesGoalSpread = r.getName();
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallesGoalSpread);
        
    }
}
