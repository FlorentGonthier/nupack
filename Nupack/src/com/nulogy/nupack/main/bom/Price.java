package com.nulogy.nupack.main.bom;

// Class representing a price (amount + currency)
public class Price 
{
	private String _currency;
	private double _amount;
	
	public Price(String iCurrency, double iAmount) 
	{
		this._currency = iCurrency;
		this._amount = iAmount;
	}

	public String getCurrency() 
	{
		return _currency;
	}

	public double getAmount() 
	{
		return _amount;
	}

}
