package com.crm.contrall;

import com.crm.dao.Leave;
import com.crm.dao.Maintain;
import com.crm.dao.User;
import com.crm.servise.LeaveService;
import com.crm.servise.MaintainService;
import com.crm.servise.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Contrall {
    @Autowired
    private UserService userService;
    @Autowired
    private MaintainService maintainService;
    @Autowired
    private LeaveService leaveService;
    @Autowired
    private StringEncryptor encryptor;
//    @RequestMapping("/index")
//    public String index(Model model) {
//        List<User> users=userService.FindAll();
//        model.addAttribute("users", users);
//        return "index";
//    }
    @RequestMapping("/")
    public String hre(){
        return "Login";
    }
    @RequestMapping("/register")
    public String register(){
        return "Register";
    }
    @RequestMapping("/Home")
    public String rt(Model model,HttpSession session){
        String name=(String)session.getAttribute("username");
        model.addAttribute("name",name);
        return "Home";
    }
    @RequestMapping("/apply/apply_1")
    public String apply_1(Model model,HttpSession session){
        String name=(String)session.getAttribute("username");
        model.addAttribute("name",name);
        return "apply_1";
    }
    @RequestMapping("/apply/apply_2")
    public String apply_2(Model model,HttpSession session){
        String name=(String)session.getAttribute("username");
        model.addAttribute("name",name);
        return "apply_2";
    }
    @RequestMapping("/apply/apply_3")
    public String apply_3(Model model,HttpSession session){
        String name=(String)session.getAttribute("username");
        model.addAttribute("name",name);
        String number=(String)session.getAttribute("number");
        List<Leave> leaves=leaveService.SelectByTo_id(number);
        List<Leave> return_leaves=leaveService.SelectByNumber(number);
        model.addAttribute("leaves",leaves);
        model.addAttribute("return_leaves",return_leaves);
        return "apply_3";
    }
    @RequestMapping("/History")
    public String history(Model model,HttpSession session){
        String name=(String)session.getAttribute("username");
        model.addAttribute("name",name);
        String number=(String)session.getAttribute("number");
        PageHelper.startPage(1,9);
        try {
            List<Maintain> userList = maintainService.SelectByState(number);
            if (userList != null) {
                PageInfo<Maintain> pageInfo = new PageInfo<>(userList);
                model.addAttribute("maintains", userList);
                model.addAttribute("pageInfo", pageInfo);
                return "history";
            } else {
                Maintain maintain2 = new Maintain();
                maintain2.setContent("---");
                maintain2.setPhone("---");
                maintain2.setName("---");
                maintain2.setSnub("---");
                maintain2.setLnub("---");
                maintain2.setXi("---");
                maintain2.setClas("---");
                maintain2.setState("---");
                maintain2.setId(0);
                model.addAttribute("maintains", maintain2);
                return "history";
            }
        }
        finally {
            PageHelper.clearPage();
        }
    }
    @RequestMapping(value = "/LoginGo", method = RequestMethod.POST)
    @ResponseBody
    public Object Login(User user, HttpSession session) {
        Map<String,Object> jsonMap = new HashMap<String,Object>();
        User i=userService.SelectNumber(user.getNumber());
        if(i!=null) {
            User user_j=new User();
            user_j.setNumber(i.getNumber());
            user_j.setName(i.getName());
            user_j.setPassword(encryptor.decrypt(i.getPassword()));
//            User u = userService.Login(user);
            if (user.getNumber().equals(user_j.getNumber())&&user.getPassword().equals(user_j.getPassword())) {
                session.setAttribute("username", user_j.getName());
                session.setAttribute("password", user_j.getPassword());
                session.setAttribute("number", user_j.getNumber());
                jsonMap.put("state", "yes");
                jsonMap.put("name", user_j.getName());
                return jsonMap;
            } else {
                jsonMap.put("state", "no");
                return jsonMap;
            }
        }
        else {
            jsonMap.put("state", "null");
            return jsonMap;
        }
    }
    @RequestMapping("/Apply")
    public String apply(Model model,HttpSession session){
        String number=(String)session.getAttribute("number");
        String name=(String)session.getAttribute("username");
        model.addAttribute("name",name);
        List<Maintain> maintain=maintainService.SelectByName(number);
        if(maintain!=null){
            model.addAttribute("maintains",maintain);
            return "apply";
        }
        else {
            Maintain maintain1=new Maintain();
            maintain1.setContent("---");
            maintain1.setPhone("---");
            maintain1.setName("---");
            maintain1.setSnub("---");
            maintain1.setLnub("---");
            maintain1.setXi("---");
            maintain1.setClas("---");
            maintain1.setState("---");
            maintain1.setId(0);
            model.addAttribute("maintains",maintain1);
            return "apply";
        }
       }
    @RequestMapping("/UpPass")
    public String UpPass(Model model,HttpSession session){
        String name=(String)session.getAttribute("username");
        model.addAttribute("name",name);
        return "UpPass";
    }
    @RequestMapping(value = "/Delete", method = RequestMethod.GET)
    public String Delete(int id,HttpSession session,Model model) {
        int i=maintainService.DeleteById(id);
        String name=(String)session.getAttribute("username");
        model.addAttribute("name",name);
        String number=(String)session.getAttribute("number");
        PageHelper.startPage(1,9);
        try {
            List<Maintain> userList = maintainService.SelectByState(number);
            if (userList != null) {
                PageInfo<Maintain> pageInfo = new PageInfo<>(userList);
                model.addAttribute("maintains", userList);
                model.addAttribute("pageInfo", pageInfo);
                return "history";
            } else {
                Maintain maintain2 = new Maintain();
                maintain2.setContent("---");
                maintain2.setPhone("---");
                maintain2.setName("---");
                maintain2.setSnub("---");
                maintain2.setLnub("---");
                maintain2.setXi("---");
                maintain2.setClas("---");
                maintain2.setState("---");
                maintain2.setId(0);
                model.addAttribute("maintains", maintain2);
                return "history";
            }
        }
        finally {
            PageHelper.clearPage();
        }
    }
//    @RequestMapping(value = "/PageSelect", method = RequestMethod.GET)
//    public String PageSelect(int id,HttpSession session,Model model) {
//         int pageStart=9*(id-1);
//         int pageEnd=9*id;
//        String name=(String)session.getAttribute("name");
//        String number=(String)session.getAttribute("number");
//        model.addAttribute("name",name);
//         List<Maintain> maintain=maintainService.SelectByPage(number,pageStart,pageEnd);
//        if(maintain!=null){
//            model.addAttribute("maintains",maintain);
//            return "history";
//        }
//        else {
//            Maintain maintain2=new Maintain();
//            maintain2.setContent("---");
//            maintain2.setPhone("---");
//            maintain2.setName("---");
//            maintain2.setSnub("---");
//            maintain2.setLnub("---");
//            maintain2.setXi("---");
//            maintain2.setClas("---");
//            maintain2.setState("---");
//            maintain2.setId(0);
//            model.addAttribute("maintains",maintain2);
//            return "history";
//        }
//
//    }
@RequestMapping("/History/Page")
public String Page(int pageNum,Model model,HttpSession session){
    String name=(String)session.getAttribute("username");
    model.addAttribute("name",name);
    String number=(String)session.getAttribute("number");
    PageHelper.startPage(pageNum,9);
    try {
        List<Maintain> userList = maintainService.SelectByState(number);
        if (userList != null) {
            PageInfo<Maintain> pageInfo = new PageInfo<>(userList);
            model.addAttribute("maintains", userList);
            model.addAttribute("pageInfo", pageInfo);
            return "history";
        } else {
            Maintain maintain2 = new Maintain();
            maintain2.setContent("---");
            maintain2.setPhone("---");
            maintain2.setName("---");
            maintain2.setSnub("---");
            maintain2.setLnub("---");
            maintain2.setXi("---");
            maintain2.setClas("---");
            maintain2.setState("---");
            maintain2.setId(0);
            model.addAttribute("maintains", maintain2);
            return "history";
        }
    }
    finally {
        PageHelper.clearPage();
    }
}
    @RequestMapping(value = "/SelectStateByName", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object>  SelectStateByName(String clas,HttpSession session, Model model) {
        Map<String,Object> jsonMap = new HashMap<String,Object>();
        List<String> state=maintainService.SelectStateByName(clas);
        jsonMap.put("state",state);
        return jsonMap;
    }

    @RequestMapping(value = "/DeleteSomeById", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object>  DelectSomeById(int[] array,HttpSession session, Model model) {
        Map<String,Object> jsonMap = new HashMap<String,Object>();
             int i=maintainService.DeleteSomeById(array);
             if(i!=0){
                 jsonMap.put("state",1);
             }
             else {
                 jsonMap.put("state",0);
             }
        return jsonMap;
    }
    @RequestMapping(value = "/SelectLeaveByMe", method = RequestMethod.GET)
    public String SelectLeaveByMe(HttpSession session,Model model) {
        String name=(String)session.getAttribute("username");
        String number=(String)session.getAttribute("number");
        model.addAttribute("name",name);
        List<Leave> leaves=leaveService.SelectByTo_id(number);
        model.addAttribute("leaves",leaves);
        return "apply_3";
    }
    @RequestMapping(value = "/SelectLeaveByRoot", method = RequestMethod.GET)
    public String SelectLeaveByRoot(HttpSession session,Model model) {
        String name=(String)session.getAttribute("username");
        model.addAttribute("name",name);
        String number=(String)session.getAttribute("number");
        List<Leave> leaves=leaveService.SelectByNumber(number);
        model.addAttribute("leaves",leaves);
        return "apply_3_Get";
    }
    @RequestMapping(value = "/DeleteLeaveByMe", method = RequestMethod.GET)
    public String  DeleteLeaveByMe(int id,HttpSession session,Model model) {
        String number=(String)session.getAttribute("number");
        String name=(String)session.getAttribute("username");
        model.addAttribute("name",name);
        leaveService.DeleteLeaveByMe(id);
        List<Leave> leaves=leaveService.SelectByTo_id(number);
        model.addAttribute("leaves",leaves);
        return "apply_3";
    }
    @RequestMapping(value = "/SelectMaintainByLikeTime", method = RequestMethod.POST)
    @ResponseBody
    public Object SelectMaintainByLikeTime(String time,HttpSession session,Model model) {
        String number=(String)session.getAttribute("number");
        Map<String,Object> jsonMap = new HashMap<String,Object>();
       List<Maintain> maintains=maintainService.SelectMaintainByLikeTime(time,number);
       if(maintains!=null || maintains.size()>0){
           jsonMap.put("maintains",maintains);
           jsonMap.put("state",1);
       }
       else {
           jsonMap.put("state",0);
       }
        return jsonMap;
    }
}