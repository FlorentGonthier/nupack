package com.nulogy.nupack.main;

import com.nulogy.nupack.main.bom.Material;
import com.nulogy.nupack.main.bom.Price;
import com.nulogy.nupack.main.bom.Project;
import com.nulogy.nupack.main.formatter.MaterialFormatter;
import com.nulogy.nupack.main.formatter.PriceFormatter;

public class MarkupCalculator 
{
	
	Project _project;
	
	// Construct the calculator with user input
	public MarkupCalculator(String iPrice, int iNbOfPeople, String iTypeOfMaterial)
	{
		Price aPrice = PriceFormatter.ToPrice(iPrice);
		Material aMaterial = MaterialFormatter.ToMaterial(iTypeOfMaterial);
		_project = new Project(aPrice, iNbOfPeople, aMaterial);
	}
	
	// Construct the calculator with user input
	public MarkupCalculator(String iPrice, int iNbOfPeople)
	{
		Price aPrice = PriceFormatter.ToPrice(iPrice);
		Material aMaterial = Material.OTHER;
		_project = new Project(aPrice, iNbOfPeople, aMaterial);
	}
	
	/**
	 * Returns the total price for a project
	 * Project is validated first and price is calculated only if validation passed
	 *
	 * @return      The formatted project total price or null if project is invalid
	 */
	public String calculateMarkup()
	{
		if (_project.validate())
		{
			return PriceFormatter.ToString(_project.calculateProjectPrice());
		}
		else
		{
			return null;
		}
	}
}
