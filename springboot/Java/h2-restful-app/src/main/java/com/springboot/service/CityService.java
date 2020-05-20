package com.springboot.service;

import com.springboot.bean.City;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
//contains the implementation of the findAll() and findById() methods
public class CityService implements ICityService {

    @Autowired
    //is injected
    private JdbcTemplate jtm;

    @Override
    public List<City> findAll() {
        //SQL to select all cities from the CITIES table
        String sql = "SELECT * FROM CITIES";
        //BeanPropertyRowMapper converts a row into a new instance of the specified mapped target class
        List<City> cities = jtm.query(sql, new BeanPropertyRowMapper(City.class));
        return cities;
    }

    @Override
    public City findById(Long id) {
        //SQL to select a specific city identified by id from the CITIES table
        String sql = "SELECT * FROM CITIES WHERE ID=?";
        //queryForObject() is used to get one row from the CITIES table
        City city = (City) jtm.queryForObject(sql, new Object[]{id},
                new BeanPropertyRowMapper(City.class));
        return city;
    }
}
