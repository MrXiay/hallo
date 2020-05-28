package com.crm.contrall;

import com.crm.dao.Maintain;
import com.crm.dao.Marster;
import com.crm.dao.RootUser;
import com.crm.dao.User;
import com.crm.servise.LeaveService;
import com.crm.servise.MasterService;
import com.crm.servise.RootUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class RootContrall {
    @Autowired
    private RootUserService rootUserService;
    @Autowired
    private MasterService masterService;
    @Autowired
    private LeaveService leaveService;

    @RequestMapping(value = "/UpDateById", method = RequestMethod.GET)
    @ResponseBody
    public String UpDateById(Maintain maintain) {
        int up=rootUserService.UpDateById(maintain);
        if(up!=0){
            return "yes_1";
        }
        else {
            return "no_1";
        }
    }
    @RequestMapping(value = "/UpDateLeaveByBack", method = RequestMethod.POST)
    public String UpDateLeaveByBack(int id) {
        int up=leaveService.UpDateLeaveByBack(id);
        if(up!=0){
            return "yes";
        }
        else {
            return "no";
        }
    }

    @RequestMapping(value = "/RootUpdatePass", method = RequestMethod.POST)
    public String RootUpdatePass(String password, HttpSession session) {
      String number = (String)session.getAttribute("number");
        int s=rootUserService.UpdatePass(number,password);
        if(s!=0){
            return "yes";
        }
        else{
            return "no";
        }
    }
    @RequestMapping(value = "/DellMasterById", method = RequestMethod.POST)
    public String DellMasterById(int id, HttpSession session) {
        int s=masterService.DellMasterById(id);
        if(s!=0){
            return "yes";
        }
        else{
            return "no";
        }
    }
    @RequestMapping(value = "/UpdateMasterById", method = RequestMethod.POST)
    public String UpdateMasterById(Marster marster, HttpSession session) {
        int s=masterService.UpdateMasterById(marster);
        if(s!=0){
            return "yes";
        }
        else{
            return "no";
        }
    }
    @RequestMapping(value = "/InsertMaster", method = RequestMethod.POST)
    public String InsertMaster(Marster marster, HttpSession session) {
        int s=masterService.InsertMaster(marster);
        if(s!=0){
            return "yes";
        }
        else{
            return "no";
        }
    }
}
