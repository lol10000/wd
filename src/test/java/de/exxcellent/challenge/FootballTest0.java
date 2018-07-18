package de.exxcellent.challenge;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.exxcellent.table.CSVReader;
import de.exxcellent.table.Result;
import de.exxcellent.table.TableAnalysis;

/**
 * Example JUnit4 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public class FootballTest0 {

    private Result r = null;

    @Before
    public void setUp() throws Exception {
        
    	String path = new File("").getAbsolutePath().concat("//src//main//resources//de//exxcellent//challenge//football.csv");
    	
    	String[][] table = CSVReader.readTable(path);
    	r = TableAnalysis.determineSolution(table, "Goals", "Goals Allowed");
    	
    }

    @Test
    public void aPointlessTest() {
    	
        Assert.assertEquals("Aston_Villa", r.getName());
    }

}