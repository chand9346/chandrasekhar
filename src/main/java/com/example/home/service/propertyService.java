package com.example.home.service;

import java.util.List;

import com.example.home.entity.Property;

public interface  propertyService {
  
    List<Property> findAll();

    Property save(Property theProperty);

    void deletebyId(int theId);

    Property findbyId(int theId);
    
}
