package com.nulogy.nupack.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.nulogy.nupack.main.MarkupCalculator;

public class MarkupCalculatorTest {

	
	@Test
	public void testSuccessCaseWithCategory() 
	{
		MarkupCalculator aMarkupCalc = new MarkupCalculator("$1299.99", 3, "food");
		String aFormattedPrice = aMarkupCalc.calculateMarkup();
		
		assertNotNull(aFormattedPrice);
		assertEquals("$1591.58", aFormattedPrice);
	}
	
	@Test
	public void testSuccessCaseWithoutCategory() 
	{
		MarkupCalculator aMarkupCalc = new MarkupCalculator("$12456.95", 4);
		String aFormattedPrice = aMarkupCalc.calculateMarkup();
		
		assertNotNull(aFormattedPrice);
		assertEquals("$13707.63", aFormattedPrice);
	}
	
	@Test
	public void testFailureInvalidNbOfPeople() 
	{
		MarkupCalculator aMarkupCalc = new MarkupCalculator("$12456.95", -1);
		String aFormattedPrice = aMarkupCalc.calculateMarkup();
		
		assertNull(aFormattedPrice);
	}

	@Test
	public void testFailureInvalidBasePrice() 
	{
		MarkupCalculator aMarkupCalc = new MarkupCalculator("3 dollars", 3);
		String aFormattedPrice = aMarkupCalc.calculateMarkup();
		
		assertNull(aFormattedPrice);
	}
	
	@Test
	public void testFailureNegativeBasePrice() 
	{
		MarkupCalculator aMarkupCalc = new MarkupCalculator("-13", 3);
		String aFormattedPrice = aMarkupCalc.calculateMarkup();
		
		assertNull(aFormattedPrice);
	}

}
