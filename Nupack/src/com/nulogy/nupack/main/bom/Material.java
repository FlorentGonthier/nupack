package com.nulogy.nupack.main.bom;

public enum Material 
{
    PHARMA(.075),
    FOOD(.13),
    ELECTRONICS(.02),
    OTHER(0);
    
    private final double _markup;

    private Material(double iMarkup) {
        this._markup = iMarkup;
    }

    public double getMarkup() {
        return _markup;
    }
}