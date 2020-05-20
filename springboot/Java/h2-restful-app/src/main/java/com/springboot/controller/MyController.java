package com.springboot.controller;
//controller class for the Spring Boot RESTful application
import com.springboot.bean.City;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import com.springboot.service.ICityService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController //creates a RESTful controller
public class MyController {

    @Autowired
    //inject a ICityService into the countryService field
    private ICityService cityService;

    @RequestMapping("/cities")//used to map web requests to Spring controller methods
    public List<City> findCities() {

        return cityService.findAll();
    }

    @RequestMapping("/cities/{userId}")
    public City findCity(@PathVariable Long userId) {

        return cityService.findById(userId);
    }
}
