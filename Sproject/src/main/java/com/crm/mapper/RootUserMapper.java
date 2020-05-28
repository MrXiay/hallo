package com.crm.mapper;


import com.crm.dao.Maintain;
import com.crm.dao.RootUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RootUserMapper {
    RootUser Login(RootUser user);
    int UpdatePass (String number,String password);
    int UpDateById (Maintain maintain);
}
