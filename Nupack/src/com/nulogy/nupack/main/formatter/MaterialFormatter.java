package com.nulogy.nupack.main.formatter;

import com.nulogy.nupack.main.bom.Material;;

public class MaterialFormatter {

	private static String FOOD_TYPE = "food";
	private static String DRUG_TYPE = "drugs";
	private static String ELECTRONICS_TYPE = "electronics";
	
	// Transform a string input into a MaterialEnum.
	// This class could be enhanced to support a list of subcategories per material. Food: fruits, meat, bread..
	public static Material ToMaterial(String iMaterial)
	{
		if (iMaterial.equalsIgnoreCase(FOOD_TYPE))
		{
			return Material.FOOD;
		}
		if (iMaterial.equalsIgnoreCase(DRUG_TYPE))
		{
			return Material.PHARMA;
		}
		if (iMaterial.equalsIgnoreCase(ELECTRONICS_TYPE))
		{
			return Material.ELECTRONICS;
		}
		
		return Material.OTHER;
	}
}
