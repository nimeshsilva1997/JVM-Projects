package com.springboot.controller;

import com.springboot.bean.Country;
import com.springboot.service.ICountryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private ICountryService countryService;

    @RequestMapping("/countries")
    public List<Country> listCountries() {
        return  countryService.findAll();
    }
}
