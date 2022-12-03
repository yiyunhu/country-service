package com.example.countryservice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountriesController {

    // https://restcountries.com/v2/all

    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @RequestMapping(value = "/countries", method = RequestMethod.GET)
    public List<Country> country() {
        List<Country> countries = new ArrayList<>();

        try {
            URL url = new URL("https://restcountries.com/v2/all");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            JSONArray arr = new JSONArray(content.toString());
            for (int i = 0; i < arr.length(); i++) {
                JSONObject jsonobj = arr.getJSONObject(i); 
                String name = jsonobj.getString("name"); 
                String code = jsonobj.getString("alpha3Code");
                countries.add(new Country(name, code));
            }

            in.close();
        } catch (Exception e) {
            return countries;
        }

        countries.add(new Country("Finland", "a"));
        return countries;
    }

    @RequestMapping(value = "/countries/{name}", method = RequestMethod.GET)
    public CountryDetail countries(@PathVariable("name") String name) {
        try {
            URL url = new URL("https://restcountries.com/v2/all");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            JSONArray arr = new JSONArray(content.toString());
            for (int i = 0; i < arr.length(); i++) {
                JSONObject jsonobj = arr.getJSONObject(i); 
                String countryName = jsonobj.getString("name"); 
                if (countryName.toLowerCase().equals(name.toLowerCase())) {
                    String code = jsonobj.getString("alpha2Code");
                    String capital = jsonobj.getString("capital");
                    int population = jsonobj.getInt("population");
                    String fileUrl = jsonobj.getString("flag");
                    CountryDetail detail = new CountryDetail(name, code, capital, population, fileUrl);
                    return detail;
                }
            }

            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

}