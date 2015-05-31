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
		return true;
	}
	
	public Price calculateProjectPrice() 
	{
		return null;
	}
}
