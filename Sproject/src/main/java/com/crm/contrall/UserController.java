package com.crm.contrall;
import com.crm.dao.Leave;
import com.crm.dao.Maintain;
import com.crm.dao.User;
import com.crm.servise.LeaveService;
import com.crm.servise.MaintainService;
import com.crm.servise.UserService;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private MaintainService maintainService;
    @Autowired
    private LeaveService leaveService;
    @Autowired
    private StringEncryptor encryptor;

//    @RequestMapping("/select/{id}")
//    public String select(@PathVariable int id) {
//        return userService.Sel(id).toString();
//    }
//
//    @RequestMapping("/de/{id}")
//    public String de(@PathVariable int id) {
//        userService.De(id);
//        return "yes";
//    }
//
//    @RequestMapping("/insert")
//    public String insert(User user) {
//        userService.Insert(user);
//        return "yes";
//    }

    @ResponseBody
    @RequestMapping(value = "/insertGo", method = RequestMethod.POST)
    public String io(Maintain maintain) {
        if(maintain!=null) {
            maintainService.Insert(maintain);
            return "yes";
        }
       else {
           return "no";
        }
    }

    @RequestMapping(value = "/passOk", method = RequestMethod.POST)
    public String passOk(String password, HttpSession session) {
        String pass_w = (String) session.getAttribute("password");
        if(pass_w.equals(password)){
            return "yes";
        }
       else{
           return "no";
        }

    }
    @RequestMapping(value = "/updatePass", method = RequestMethod.POST)
    public String updatePass(String password, HttpSession session) {
       String number =(String)session.getAttribute("number");
        int s=userService.UpdatePass(number,encryptor.encrypt(password));
        if(s!=0){
            return "yes";
        }
        else{
            return "no";
        }
    }
    @RequestMapping(value = "/InsertLeave_table", method = RequestMethod.POST)
    public String InsertLeave_table(Leave leave) {
        if(leave.getContent()!="") {
            leaveService.InsertLeave_table(leave);
            return "yes";
        }
        else {
            return "no";
        }
    }
    @RequestMapping(value = "/RegisterGo", method = RequestMethod.POST)
    public String RegisterGo(User user) {
        User user_j=new User();
        user_j.setNumber(user.getNumber());
        user_j.setName(user.getName());
        user_j.setPassword(encryptor.encrypt(user.getPassword()));
        User i=userService.SelectNumber(user.getNumber());
        if(i==null) {
           userService.InsertUser(user_j);
            return "yes";
        }
        else {
            return "no";
        }
    }
}