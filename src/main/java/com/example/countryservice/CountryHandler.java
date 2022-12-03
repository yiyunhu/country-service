package com.example.countryservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
public class CountryHandler {
    @Autowired
    private CountriesController countriesController;

    @RequestMapping(value = "/country/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String countries(@PathVariable("name") String name) {
        CountryDetail detail = countriesController.countries(name);
        StringBuilder builder = new StringBuilder();
        builder.append("<html><header><title>");
        builder.append(detail.getName());
        builder.append("</title>");
        builder.append("</header><body>");
        builder.append("<h1>" + detail.getName() + "</h1>");
        builder.append("<h2>Country Code: " + detail.getCountryCode() + "</h2>");
        builder.append("<h2>Capital: " + detail.getCapital() + "</h2>");
        builder.append("<h2>Population: " + detail.getPopulation() + "</h1>");
        builder.append("<img src=\"" + detail.getFileUrl() + "\" width=288 height=auto>");
        builder.append("</body></html>");
        return builder.toString();
    }
}
