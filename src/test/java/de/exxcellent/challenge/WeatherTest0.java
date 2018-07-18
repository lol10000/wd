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
public class WeatherTest0 {

    private Result r = null;

    @Before
    public void setUp() throws Exception {
        
    	String path = new File("").getAbsolutePath().concat("//src//main//resources//de//exxcellent//challenge//weather.csv");
    	
    	String[][] table = CSVReader.readTable(path);
    	r = TableAnalysis.determineSolution(table, "MxT", "MnT");
    	
    }

    @Test
    public void aPointlessTest() {
    	
        Assert.assertEquals("14", r.getName());
    }

}