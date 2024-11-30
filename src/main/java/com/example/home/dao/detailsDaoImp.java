package com.example.home.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.home.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class detailsDaoImp implements detailsDao{

    private EntityManager entityManager;

    public detailsDaoImp(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }

    @Override
    public List<User> findAll() {
       TypedQuery<User> theQuery=entityManager.createQuery("from User ",User.class);
       List<User> users= theQuery.getResultList();
       return users;
    }

    @Override
    public User findById(int id) {
       User thUser=entityManager.find(User.class,id);
       return thUser;
    }
    
}
