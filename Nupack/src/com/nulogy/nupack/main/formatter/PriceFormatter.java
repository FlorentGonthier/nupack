package com.nulogy.nupack.main.formatter;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nulogy.nupack.main.bom.Price;

public class PriceFormatter {
	
	/**
	 * Convert a Price object to a printable string
	 * Formatting keeps 2 decimal places and provides currency. 
	 *
	 * @param  iPrice The price object to convert
	 * @return        The string version of the price
	 */
	public static String ToString(Price iPrice)
	{
		if (null != iPrice)
		{
			// Converts to double with 2 decimal places (format of a typical price)
			// and add currency to the price
			DecimalFormat aFormatter = new DecimalFormat("#.##");
			return iPrice.getCurrency() + aFormatter.format(iPrice.getAmount());
		}
		else
		{
			return null;
		}		
	}
	
	/**
	 * Convert a string price to a Price object
	 * Currency and amount are extracted and stored in the Price object 
	 *
	 * @param  iPrice The string description of a price
	 * @return        The Price object
	 */
	public static Price ToPrice(String iPrice)
	{
		// Try to match Currency (first brackets) and everything else (other brackets)
		// If conversion to double fails, we have an invalid number
		
		// Create a Pattern and matcher objects
		Pattern aPattern = Pattern.compile("([^-\\d]*)(.*)");
		Matcher aMatcher = aPattern.matcher(iPrice);
		
		if (aMatcher.find())
		{
			try 
			{
				// Try to create a double from the input string
				double anAmount = Double.parseDouble(aMatcher.group(2));
				return new Price(aMatcher.group(1), anAmount);
			}
			catch (Exception e)
			{
				return null;
			}
			
		}
		else
		{
			return null;
		}
	}
}
