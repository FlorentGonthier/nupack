package com.nulogy.nupack.main.bom;


public class Project 
{
	private static double BASE_MARKUP = .05;
	private static double PER_PERSON_MARKUP = .012;
	
	private int _nbOfPeople;
	private Price _basePrice;
	private Material _material;
	
	public Project(Price iBasePrice, int iNbOfPeople) 
	{
		this._nbOfPeople = iNbOfPeople;
		this._basePrice = iBasePrice;
		this._material = Material.OTHER;
	}

	public Project(Price iBasePrice, int iNbOfPeople, Material iMaterial) 
	{
		this._nbOfPeople = iNbOfPeople;
		this._basePrice = iBasePrice;
		this._material = iMaterial;
	}
	
	public Boolean validate()
	{
		if (_nbOfPeople < 0)
		{
			System.out.println("Number of people should be at least 0");
			return false;
		}
		
		if (null == _basePrice)
		{
			System.out.println("Base price is invalid");
			return false;
		}
		
		if (_basePrice.getAmount() < 0)
		{
			System.out.println("Base price should be at least 0");
			return false;
		}
		
		return true;
	}
	
	public Price calculateProjectPrice() 
	{
		double anAmount = (_basePrice.getAmount() * (1+BASE_MARKUP)) * (1+ _nbOfPeople * PER_PERSON_MARKUP + _material.getMarkup());
		return new Price(_basePrice.getCurrency(), anAmount);
	}
}
