package com.example.home.dao;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.example.home.entity.Property;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


@Repository
public class propertyDaoImp implements propertyDao{


    private EntityManager entityManager;

    public propertyDaoImp(EntityManager theEntityManager){
        this.entityManager=theEntityManager;
    }

    @Override
    public List<Property> findAll() {
       TypedQuery<Property> theQuery=entityManager.createQuery("from Property",Property.class);
       List<Property> theList=theQuery.getResultList();
       return theList;
    }

    @Override
    public Property save(Property theProperty) {
       Property dbProperty=entityManager.merge(theProperty);
       return dbProperty;
    }

    @Override
    public void deletebyId(int theId) {
      Property delProperty=entityManager.find(Property.class, theId);
      entityManager.remove(delProperty);
    }

    @Override
    public Property findbyId(int theId) {
       Property theProperty=entityManager.find(Property.class,theId);
       return theProperty;
    }
    
}
