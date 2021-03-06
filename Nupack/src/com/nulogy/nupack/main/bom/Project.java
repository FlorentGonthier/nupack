package com.nulogy.nupack.main.bom;

// This class describes what a project needs to be executed:
//	- People
//	- Base Price
//	- Type of material
// and allows total price calculation based on these params
public class Project 
{
	private static double BASE_MARKUP = .05;
	private static double PER_PERSON_MARKUP = .012;
	
	private int _nbOfPeople;
	private Price _basePrice;
	private Material _material;
	
	// Initialize a project with no material information
	public Project(Price iBasePrice, int iNbOfPeople) 
	{
		this._nbOfPeople = iNbOfPeople;
		this._basePrice = iBasePrice;
		this._material = Material.OTHER;
	}

	// Initialize a project with material information
	public Project(Price iBasePrice, int iNbOfPeople, Material iMaterial) 
	{
		this._nbOfPeople = iNbOfPeople;
		this._basePrice = iBasePrice;
		this._material = iMaterial;
	}

	/**
	 * Check if a project is valid
	 * Several conditions are checked:
	 * 		- Number of people involved cannot be negative
	 * 		- Base price needs to be valid and cannot be negative
	 *
	 * @return      True is project is valid and price cannot be calculated
	 */
	public Boolean validate()
	{
		// Check if number of people is valid
		if (_nbOfPeople < 0)
		{
			System.out.println("Number of people should be at least 0");
			return false;
		}
		
		// Check if base price is defined
		if (null == _basePrice)
		{
			System.out.println("Base price is invalid");
			return false;
		}
		
		// Check if base price is valid
		if (_basePrice.getAmount() < 0)
		{
			System.out.println("Base price should be at least 0");
			return false;
		}
		
		return true;
	}
	
	private double getBaseAmount()
	{
		return _basePrice.getAmount();
	}
	
	private double applyBaseMarkup(double iBaseAmount)
	{
		return iBaseAmount * (1 + BASE_MARKUP);
	}
	
	private double getWorkerMarkup()
	{
		return _nbOfPeople * PER_PERSON_MARKUP;
	}
	
	private double getMaterialMarkup()
	{
		return _material.getMarkup();
	}
	
	private double applyOtherMarkups(double iBaseAmount)
	{
		double aTotalOtherMarkup = getMaterialMarkup() + getWorkerMarkup();
		return iBaseAmount * (1 + aTotalOtherMarkup );
	}
	
	/**
	 * Returns The computed price of a project: 
	 * A flat markup is calculated first and then other possible markups
	 * may be applied depending on the number of people involved
	 * and the type of goods 
	 *
	 * @return      The calculated price of the project
	 */
	public Price calculateProjectPrice() 
	{
		double anAmount = getBaseAmount();
		anAmount = applyBaseMarkup(anAmount);
		anAmount = applyOtherMarkups(anAmount);
		
		return new Price(_basePrice.getCurrency(), anAmount);
	}
}
