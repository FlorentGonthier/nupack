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
		System.out.println("PriceFormatterTest: Testing success with currency");
		Price aPrice = PriceFormatter.ToPrice("$123.345");
		assertNotNull(aPrice);
		assertEquals("$", aPrice.getCurrency());
		assertEquals(123.345, aPrice.getAmount(), ACCEPTED_DELTA);
	}
	
	@Test
	public void testSuccessWithCurrencyAndNegVal() 
	{
		// Validate price parsing for standard negative input
		System.out.println("PriceFormatterTest: Testing success with currency and negative value");
		Price aPrice = PriceFormatter.ToPrice("$-123.345");
		assertNotNull(aPrice);
		assertEquals("$", aPrice.getCurrency());
		assertEquals(-123.345, aPrice.getAmount(), ACCEPTED_DELTA);
	}
	
	@Test
	public void testSuccessWithoutCurrency() 
	{
		// Validate price parsing for standard input with no currency information
		System.out.println("PriceFormatterTest: Testing success without currency");
		Price aPrice = PriceFormatter.ToPrice("123.345");
		assertNotNull(aPrice);
		assertEquals("", aPrice.getCurrency());
		assertEquals(123.345, aPrice.getAmount(), ACCEPTED_DELTA);
	}
	
	@Test
	public void testFailureInvalidNumberWithCurrency() 
	{
		// Validate price parsing for invalid price value
		System.out.println("PriceFormatterTest: Testing failure with invalid price");
		Price aPrice = PriceFormatter.ToPrice("$abc");
		assertEquals(null, aPrice);
	}
	
	@Test
	public void testFailureInvalidNumberWithoutCurrency() 
	{
		// Validate price parsing for invalid price value
		System.out.println("PriceFormatterTest: Testing failure with invalid price and without currency");
		Price aPrice = PriceFormatter.ToPrice("abc");
		assertEquals(null, aPrice);
	}
}
