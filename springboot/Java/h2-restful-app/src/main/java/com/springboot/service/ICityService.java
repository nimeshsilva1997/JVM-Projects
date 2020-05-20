package com.springboot.service;

import com.springboot.bean.City;
import java.util.List;
//provides contract methods to get all cities and get a city by its id from the data source
public interface ICityService {

    public List<City> findAll();
    public City findById(Long id);
}
