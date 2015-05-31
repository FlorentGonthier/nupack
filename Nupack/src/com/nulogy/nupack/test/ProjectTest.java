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
		Price aBasePrice = new Price(DOLLAR_CURRENCY, 1299.99);
		
		Project aProject = new Project(aBasePrice, 3, Material.FOOD);
		Price aResult = aProject.calculateProjectPrice();
		
		assertNotNull(aResult);
		assertEquals(1591.58, aResult.getAmount(), ACCEPTED_DELTA);
	}
	
	@Test
	public void testSuccessPharmaCategory() 
	{
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
		Price aBasePrice = new Price(DOLLAR_CURRENCY, 0);	
		Project aProject = new Project(aBasePrice, 4, Material.OTHER);
		
		assertTrue(aProject.validate());
		Price aResult = aProject.calculateProjectPrice();
		assertNotNull(aResult);
		assertEquals(0, aResult.getAmount(), ACCEPTED_DELTA);
	}
	
	@Test
	public void testNbOfPeopleValidationFailure() 
	{
		Price aBasePrice = new Price(DOLLAR_CURRENCY, 12456.95);
		Project aProject = new Project(aBasePrice, -1, Material.OTHER);
		
		assertFalse(aProject.validate());
	}
	
	@Test
	public void testBasePriceValidationFailure() 
	{
		Price aBasePrice = new Price(DOLLAR_CURRENCY, -3);
		Project aProject = new Project(aBasePrice, 1, Material.OTHER);
		
		assertFalse(aProject.validate());
	}

}
