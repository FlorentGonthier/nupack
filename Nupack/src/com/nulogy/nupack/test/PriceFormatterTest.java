package com.nulogy.nupack.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.nulogy.nupack.main.bom.Price;
import com.nulogy.nupack.main.formatter.PriceFormatter;

public class PriceFormatterTest 
{
	private static double ACCEPTED_DELTA = 0;
	
	@Test
	public void testSuccessWithCurrency() 
	{
		// Validate price parsing for standard input
		Price aPrice = PriceFormatter.ToPrice("$123.345");
		assertNotNull(aPrice);
		assertEquals("$", aPrice.getCurrency());
		assertEquals(123.345, aPrice.getAmount(), ACCEPTED_DELTA);
	}
	
	@Test
	public void testSuccessWithCurrencyAndNegVal() 
	{
		// Validate price parsing for standard negative input
		Price aPrice = PriceFormatter.ToPrice("$-123.345");
		assertNotNull(aPrice);
		assertEquals("$", aPrice.getCurrency());
		assertEquals(-123.345, aPrice.getAmount(), ACCEPTED_DELTA);
	}
	
	@Test
	public void testSuccessWithoutCurrency() 
	{
		// Validate price parsing for standard input with no currency information
		Price aPrice = PriceFormatter.ToPrice("123.345");
		assertNotNull(aPrice);
		assertEquals("", aPrice.getCurrency());
		assertEquals(123.345, aPrice.getAmount(), ACCEPTED_DELTA);
	}
	
	@Test
	public void testFailureInvalidNumberWithCurrency() 
	{
		// Validate price parsing for invalid price value
		Price aPrice = PriceFormatter.ToPrice("$abc");
		assertEquals(null, aPrice);
	}
	
	@Test
	public void testFailureInvalidNumberWithoutCurrency() 
	{
		// Validate price parsing for invalid price value
		Price aPrice = PriceFormatter.ToPrice("abc");
		assertEquals(null, aPrice);
	}
}
