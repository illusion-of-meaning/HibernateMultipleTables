package com.asherbakov.dao;

import com.asherbakov.entity.City;

import java.sql.SQLException;

public interface CityDAO {
    City getCityById(Long id) throws SQLException;
}
