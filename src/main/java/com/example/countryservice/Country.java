package com.example.countryservice;

public class Country {
    private final String name;
    private final String countryCode;

    public Country(String name, String countryCode) {
        this.name = name;
        this.countryCode = countryCode;
    }

    public String getName() {
        return this.name;
    }

    public String getCountryCode() {
        return this.countryCode;
    }
}
