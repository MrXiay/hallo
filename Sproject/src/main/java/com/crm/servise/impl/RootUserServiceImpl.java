package com.crm.servise.impl;

import com.crm.dao.Maintain;
import com.crm.dao.RootUser;
import com.crm.dao.User;
import com.crm.mapper.RootUserMapper;
import com.crm.mapper.UserMapper;
import com.crm.servise.RootUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RootUserServiceImpl implements RootUserService {
    @Autowired
    private RootUserMapper rootUserMapper;
    @Override
    public RootUser Login(RootUser user){
        return rootUserMapper.Login(user);
    }
    @Override
    public  int UpdatePass(String number,String password){
        return rootUserMapper.UpdatePass(number,password);
    }
    @Override
    public int UpDateById (Maintain maintain){
        return rootUserMapper.UpDateById(maintain);
    }
}
