package com.springboot.service;
//fields from the countries.csv file are mapped to the Country class
import com.springboot.bean.Country;
import java.util.ArrayList;

public interface ICountryService {
    //This is the ICountryService interface. It contains one method called findAll()
    public ArrayList<Country> findAll();
}
