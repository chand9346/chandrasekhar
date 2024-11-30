package com.example.home.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.home.dao.detailsDao;
import com.example.home.entity.User;


@Service
public class detailsServiceImp implements detailsService {

    //inject detailsDao
    private detailsDao thedetailsDao;

    public detailsServiceImp(detailsDao detailsdao){
        this.thedetailsDao=detailsdao;
    }

    @Override
    public List<User> findAll() {
        return thedetailsDao.findAll();
    }

    @Override
    public User findbyId(int id) {
        return thedetailsDao.findById(id);
    }
    
}
