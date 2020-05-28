package com.crm.mapper;

import com.crm.dao.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
public interface UserMapper {
     User Login(User user);
    int UpdatePass (String number,String password);
    int InsertUser(User user);
    User SelectNumber(String number);
}