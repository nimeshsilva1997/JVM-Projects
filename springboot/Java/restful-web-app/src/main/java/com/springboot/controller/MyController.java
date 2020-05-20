package com.springboot.controller;
//controller class for the Spring Boot RESTful application
import com.springboot.bean.Country;
import com.springboot.service.ICountryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController//creates a RESTful controller
public class MyController {

    @Autowired
    private ICountryService countryService;
//inject a CountryService into the countryService variable
    @RequestMapping(value = "/countries", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE) //used to map web requests to Spring controller methods. Tells the controller to return XML data
    public List<Country> listCountries() {
        return  countryService.findAll();
    }
}
