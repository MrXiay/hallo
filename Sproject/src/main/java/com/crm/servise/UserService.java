package com.crm.servise;

import com.crm.dao.User;

import java.util.List;

public interface UserService {
    User Login(User user);
    int UpdatePass (String number,String password);
    int InsertUser(User user);
    User SelectNumber(String number);
}
