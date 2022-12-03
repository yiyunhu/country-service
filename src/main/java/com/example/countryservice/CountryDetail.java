package com.example.countryservice;

public class CountryDetail {
    private final String name;
    private final String countryCode;
    private final String capital;
    private final int population;
    private final String fileUrl;

    public CountryDetail(String name, String countryCode, String capital, int population, String fileUrl) {
        this.name = name;
        this.countryCode = countryCode;
        this.capital = capital;
        this.population = population;
        this.fileUrl = fileUrl;
    }

    public String getName() {
        return this.name;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getCapital() {
        return this.capital;
    }

    public int getPopulation() {
        return this.population;
    }

    public String getFileUrl() {
        return this.fileUrl;
    }
}
