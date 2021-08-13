package com.jihee.nlcamping.spinner;

public class CountryItem {
    private String countryLanguage;
    private int flagImage;

    public CountryItem(String countryLanguage, int flagImage){
        this.countryLanguage = countryLanguage;
        this.flagImage = flagImage;
    }

    public int getFlagImage() {
        return flagImage;
    }

    public String getCountryLanguage() {
        return countryLanguage;
    }


}