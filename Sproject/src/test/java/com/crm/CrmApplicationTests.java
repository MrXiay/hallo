package com.crm;

import com.crm.dao.Leave;
import com.crm.dao.Maintain;
import com.crm.dao.Marster;
import com.crm.dao.User;
import com.crm.mapper.UserMapper;
import com.crm.servise.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.sql.Array;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrmApplicationTests {
//    Logger logger = LoggerFactory.getLogger(this.getClass());
//    private StringEncryptor encryptor;
    @Test
    public void contextLoads() {
//        User user=new User();
//        user.setName("ju");
//        user.setNumber("1620031858");
//        user.setPassword(encryptor.encrypt("123456"));
//        logger.info("{}",user.getPassword());
//        logger.info("[{}]",encryptor.decrypt(user.getPassword()));
    }
//    @Test
//    public void InsertMaster(){
//        Marster m=new Marster();
//        m.setLocation("1");
//        m.setPhone("67");
//        m.setName("9");
//        masterService.InsertMaster(m);
//    }
//    @Test
//    public void SelectName(){
//       maintainService.SelectById_rootApply(82);
//            logger.info("1");
//    }
//    @Test
//    public void SelectByXi(){
//        logger.info("1");
//    }
//    @Test
//    public void SelectByLou(){
//        logger.info("1");
//    }
//    @Test
//    public void PageHelper() {
//        PageHelper.startPage(1, 7);
//        List<Marster> userList = masterService.SelectAll();
//        PageInfo<Marster> pageInfo = new PageInfo<>(userList);
//        logger.info("[{}]",pageInfo.toString());
//        int i=pageInfo.getNextPage();
//
//    }
//    @Test
//    public void SelectMaster() {
//       List<Marster> masters=masterService.SelectAllByName("23");
//        for(int i=0;i<masters.size();i++){
//            logger.info("[{}]",masters.toArray()[i]);
//        }
//
//    }
//    @Test
//    public void InsertLeave() {
//        Leave leave=new Leave();
//        leave.setTime("1");;
//        leave.setContent("34");
//        leave.setFrom_id("we");
//        leave.setFrom_number("1");
////        leave.setTo_id("324");
////        leave.setTo_number("sdg");
//
//      leaveService.InsertLeave_table(leave);
//
//    }
//    @Test
//    public void SelectLeave() {
//        List<Leave> leaveList=leaveService.SelectByTo_id("111");
//        for(int i=0;i<leaveList.size();i++){
//            logger.info("[{}]",leaveList.toArray()[i]);
//        }
//
//    }
//    @Test
//    public void SelectLeaveAll() {
//        List<Leave> leaveList=leaveService.SelectStudent_LeaveAll();
//        for(int i=0;i<leaveList.size();i++){
//            logger.info("[{}]",leaveList.toArray()[i]);
//        }
//
//    }
//    @Test
//    public void DeletetLeave() {
//        int[] array = new int[2];
//        array[0] = 13;
//        array[1] = 16;
//      int i=leaveService.DeleteSomeById(array);
//        logger.info("[{}]",i);
//    }
//    @Test
//    public void UpdateLeave() {
//        int i=leaveService.UpDateLeaveByBack(32);
//    }
//    @Test
//    public void SelectBack() {
//        List<Leave> leaveList=leaveService.SelectLeaveByBack("已回复");
//        for(int i=0;i<leaveList.size();i++){
//            logger.info("[{}]",leaveList.toArray()[i]);
//        }
//    }
//    @Test
//    public void InsetUser(){
//
//    }
//    @Test
//    public void SelectUser(){
//        User i=userService.SelectNumber("111");
//            logger.info("[{}]", i);
//    }
 }
