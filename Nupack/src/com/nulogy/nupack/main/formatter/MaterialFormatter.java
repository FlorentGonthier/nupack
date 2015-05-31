package com.nulogy.nupack.main.formatter;

import com.nulogy.nupack.main.bom.Material;;

public class MaterialFormatter {

	
	public static Material ToMaterial(String iMaterial)
	{
		if (iMaterial.equalsIgnoreCase("food"))
		{
			return Material.FOOD;
		}
		if (iMaterial.equalsIgnoreCase("drugs"))
		{
			return Material.PHARMA;
		}
		if (iMaterial.equalsIgnoreCase("electronics"))
		{
			return Material.ELECTRONICS;
		}
		
		return Material.OTHER;
	}
}
