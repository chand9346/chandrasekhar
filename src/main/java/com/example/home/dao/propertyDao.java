package com.example.home.dao;

import java.util.List;

import com.example.home.entity.Property;

public interface propertyDao {

    List<Property> findAll();

    Property save(Property theProperty);

    void deletebyId(int theId);

    Property findbyId(int theId);
    
}
