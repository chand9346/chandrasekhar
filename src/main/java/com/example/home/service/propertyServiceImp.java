package com.example.home.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.home.dao.propertyDao;
import com.example.home.entity.Property;

import jakarta.transaction.Transactional;

@Service
public class propertyServiceImp implements propertyService{

    private propertyDao propertydao;

    public propertyServiceImp(propertyDao thePropertyDao){
        this.propertydao=thePropertyDao;
    }



    @Override
    public List<Property> findAll() {
       return propertydao.findAll();
    }

    @Override
    @Transactional
    public Property save(Property theProperty) {
      return propertydao.save(theProperty);
    }

    @Override
    @Transactional
    public void deletebyId(int theId) {
     propertydao.deletebyId(theId);
    }



    @Override
    public Property findbyId(int theId) {
       return propertydao.findbyId(theId);
    }
    
}
