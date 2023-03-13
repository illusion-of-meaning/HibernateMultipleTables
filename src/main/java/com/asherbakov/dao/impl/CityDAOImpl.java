package com.asherbakov.dao.impl;

import com.asherbakov.HibernateManager;
import com.asherbakov.dao.CityDAO;
import com.asherbakov.entity.City;

public class CityDAOImpl implements CityDAO {
    @Override
    public City getCityById(Long id) {
        return HibernateManager.getSessionFactory().openSession().get(City.class, id);
    }
}
