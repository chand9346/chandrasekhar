package com.example.home.dao;

import java.util.List;

import com.example.home.entity.User;

public interface detailsDao {

    List<User> findAll();
    User findById(int id);
    
}
