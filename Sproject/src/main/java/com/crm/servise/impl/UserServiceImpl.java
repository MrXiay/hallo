package com.crm.servise.impl;

import com.crm.dao.User;
import com.crm.mapper.UserMapper;
import com.crm.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User Login(User user){
        return userMapper.Login(user);
    }
    public  int UpdatePass(String number,String password){
        return userMapper.UpdatePass(number,password);
    }
    public  int InsertUser(User user){
        return userMapper.InsertUser(user);
    }
    public User SelectNumber(String number){
        return userMapper.SelectNumber(number);
    }
}

