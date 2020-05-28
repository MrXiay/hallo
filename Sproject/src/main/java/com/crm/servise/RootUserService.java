package com.crm.servise;

import com.crm.dao.Maintain;
import com.crm.dao.RootUser;

public interface RootUserService {
    RootUser Login(RootUser user);
    int UpdatePass (String number,String password);
    int UpDateById (Maintain maintain);
}
