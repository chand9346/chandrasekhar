package com.example.home.service;

import java.util.List;

import com.example.home.entity.User;

public interface detailsService {

    
    List<User> findAll();

    User findbyId(int id);
    
    
}
