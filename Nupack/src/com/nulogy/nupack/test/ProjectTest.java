package com.nulogy.nupack.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.nulogy.nupack.main.bom.Material;
import com.nulogy.nupack.main.bom.Price;
import com.nulogy.nupack.main.bom.Project;

public class ProjectTest {

	// The Project class only does the price calculation but does not handle price formatting
	// We may then end up with several decimal digits
	private static double ACCEPTED_DELTA = 0.01;
	private static String DOLLAR_CURRENCY = "$";
	
	@Test
	public void testSuccessFoodCategory() 
	{
		// Testing success with food category
		System.out.println("ProjectTest: Testing success with food category");
		Price aBasePrice = new Price(DOLLAR_CURRENCY, 1299.99);
		
		Project aProject = new Project(aBasePrice, 3, Material.FOOD);
		Price aResult = aProject.calculateProjectPrice();
		
		assertNotNull(aResult);
		assertEquals(1591.58, aResult.getAmount(), ACCEPTED_DELTA);
	}
	
	@Test
	public void testSuccessPharmaCategory() 
	{
		// Testing success with pharma category
		System.out.println("ProjectTest: Testing success with pharma category");
		Price aBasePrice = new Price(DOLLAR_CURRENCY, 5432.00);
		Project aProject = new Project(aBasePrice, 1, Material.PHARMA);
		
		assertTrue(aProject.validate());
		Price aResult = aProject.calculateProjectPrice();
		assertNotNull(aResult);
		assertEquals(6199.81, aResult.getAmount(), ACCEPTED_DELTA);
	}
	
	@Test
	public void testSuccessOtherCategory() 
	{
		// Testing success with other category
		System.out.println("ProjectTest: Testing success with other category");
		Price aBasePrice = new Price(DOLLAR_CURRENCY, 12456.95);	
		Project aProject = new Project(aBasePrice, 4, Material.OTHER);
		
		assertTrue(aProject.validate());
		Price aResult = aProject.calculateProjectPrice();
		assertNotNull(aResult);
		assertEquals(13707.63, aResult.getAmount(), ACCEPTED_DELTA);
	}
	
	@Test
	public void testSuccessFreeProject() 
	{
		// Testing success with $0 project
		System.out.println("ProjectTest: Testing success with $0 project");
		Price aBasePrice = new Price(DOLLAR_CURRENCY, 0);	
		Project aProject = new Project(aBasePrice, 4, Material.OTHER);
		
		assertTrue(aProject.validate());
		Price aResult = aProject.calculateProjectPrice();
		assertNotNull(aResult);
		assertEquals(0, aResult.getAmount(), ACCEPTED_DELTA);
	}
	
	@Test
	public void testNumberOfPeopleValidationFailure() 
	{
		// Testing success with invalid number of people
		System.out.println("ProjectTest: Testing failure with invalid number of people");
		Price aBasePrice = new Price(DOLLAR_CURRENCY, 12456.95);
		Project aProject = new Project(aBasePrice, -1, Material.OTHER);
		
		assertFalse(aProject.validate());
	}
	
	@Test
	public void testBasePriceValidationFailure() 
	{
		// Testing success with invalid base price
		System.out.println("ProjectTest: Testing failure with invalid base price");
		Price aBasePrice = new Price(DOLLAR_CURRENCY, -3);
		Project aProject = new Project(aBasePrice, 1, Material.OTHER);
		
		assertFalse(aProject.validate());
	}

}
