package com.crm.contrall;
import com.crm.dao.Leave;
import com.crm.dao.Maintain;
import com.crm.dao.Marster;
import com.crm.dao.RootUser;
import com.crm.servise.LeaveService;
import com.crm.servise.MaintainService;
import com.crm.servise.MasterService;
import com.crm.servise.RootUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Contrall_Root {
        @Autowired
        private MaintainService maintainService;
        @Autowired
         private MasterService masterService;
        @Autowired
        private LeaveService leaveService;
    @Autowired
    private RootUserService rootUserService;
        @RequestMapping("/rootHome")
        public String hre(Model model,HttpSession session) {
            String name = (String) session.getAttribute("username");
            model.addAttribute("name", name);
            return "rootHome";
        }
    @RequestMapping("/rootLeave")
    public String Leave(Model model,HttpSession session) {
        String name = (String) session.getAttribute("username");
        model.addAttribute("name", name);
        PageHelper.startPage(1,9);
        try {
            List<Leave> userList =leaveService.SelectStudent_LeaveAll();
            PageInfo<Leave> pageInfo = new PageInfo<>(userList);
            model.addAttribute("leaves",userList);
            model.addAttribute("pageInfo",pageInfo);
        }
        finally {
            PageHelper.clearPage();
        }
        return "rootLeave";
    }
    @RequestMapping("/rootLeaveReturn")
    public String Leave_return(Model model,HttpSession session) {
        String name = (String) session.getAttribute("username");
        model.addAttribute("name", name);
        List<Leave> userList =leaveService.SelectByRootAll();
        model.addAttribute("leaves",userList);
        return "rootLeave_Return";
    }
    @RequestMapping(value ="/rootLeave_NoBack",method = RequestMethod.GET)
    public String Leave_NoBack(Model model,HttpSession session) {
        String name = (String) session.getAttribute("username");
        model.addAttribute("name", name);
        String back="未回复";
        PageHelper.startPage(1,9);
        try {
            List<Leave> userList =leaveService.SelectLeaveByBack(back);
            PageInfo<Leave> pageInfo = new PageInfo<>(userList);
            model.addAttribute("leaves",userList);
            model.addAttribute("pageInfo",pageInfo);
        }
        finally {
            PageHelper.clearPage();
        }
        return "rootLeave_NoBack";
    }
    @RequestMapping(value ="/rootLeave_OkBack",method = RequestMethod.GET)
    public String Leave_OkBack(Model model,HttpSession session) {
        String name = (String) session.getAttribute("username");
        model.addAttribute("name", name);
        String back="已回复";
        PageHelper.startPage(1,9);
        try {
            List<Leave> userList =leaveService.SelectLeaveByBack(back);
            PageInfo<Leave> pageInfo = new PageInfo<>(userList);
            model.addAttribute("leaves",userList);
            model.addAttribute("pageInfo",pageInfo);
        }
        finally {
            PageHelper.clearPage();
        }
        return "rootLeave_OkBack";
    }
    @RequestMapping(value ="/rootLeave_NoBac/PageSelectAll",method = RequestMethod.GET)
    public String Leave_NoBackAll(int pageNum,Model model,HttpSession session) {
        String name = (String) session.getAttribute("username");
        model.addAttribute("name", name);
        String back="未回复";
        PageHelper.startPage(pageNum,9);
        try {
            List<Leave> userList =leaveService.SelectLeaveByBack(back);
            PageInfo<Leave> pageInfo = new PageInfo<>(userList);
            model.addAttribute("leaves",userList);
            model.addAttribute("pageInfo",pageInfo);
        }
        finally {
            PageHelper.clearPage();
        }
        return "rootLeave_NoBack";
    }
    @RequestMapping(value ="/rootLeave_OkBack/pageSelectAll",method = RequestMethod.GET)
    public String Leave_OkBackAll(int pageNum,Model model,HttpSession session) {
        String name = (String) session.getAttribute("username");
        model.addAttribute("name", name);
        String back="已回复";
        PageHelper.startPage(pageNum,9);
        try {
            List<Leave> userList =leaveService.SelectLeaveByBack(back);
            PageInfo<Leave> pageInfo = new PageInfo<>(userList);
            model.addAttribute("leaves",userList);
            model.addAttribute("pageInfo",pageInfo);
        }
        finally {
            PageHelper.clearPage();
        }
        return "rootLeave_OkBack";
    }
        @RequestMapping("/rootUpPass")
        public String rootUpPass(Model model,HttpSession session) {
            String name = (String) session.getAttribute("username");
            model.addAttribute("name", name);
            return "rootUpPass";
        }
       @RequestMapping("/rootPhone")
        public String rootPhone(Model model,HttpSession session) {
        String name = (String) session.getAttribute("username");
        model.addAttribute("name", name);
//              PageHelper.startPage(1,7);
           try {
               List<Marster> userList = masterService.SelectAll();
//               PageInfo<Marster> pageInfo = new PageInfo<>(userList);
               model.addAttribute("masters",userList);
               model.addAttribute("Master",new Marster());
//               model.addAttribute("pageInfo",pageInfo);
           }
           finally {
               PageHelper.clearPage();
           }
        return "rootPhone";
    }
    @RequestMapping("/rootPhone_1")
    public String rootPhone_1(Model model,HttpSession session) {
        String name = (String) session.getAttribute("username");
        model.addAttribute("name", name);
        PageHelper.startPage(1,7);
        try {
            List<Marster> userList = masterService.SelectAll();
            PageInfo<Marster> pageInfo = new PageInfo<>(userList);
            model.addAttribute("masters",userList);
            model.addAttribute("pageInfo",pageInfo);
        }
        finally {
            PageHelper.clearPage();
        }
        return "rootPhone_1";
    }
    @RequestMapping(value = "/RootLoginGo",method = RequestMethod.POST)
    @ResponseBody
    public Object RootLoginGo(RootUser user, HttpSession session) {
        Map<String,Object> jsonMap = new HashMap<String,Object>();
        RootUser u = rootUserService.Login(user);
        if (u != null) {
            session.setAttribute("username", u.getName());
            session.setAttribute("password", u.getPassword());
            session.setAttribute("number",u.getNumber());
            jsonMap.put("state","yes");
            jsonMap.put("name",u.getName());
            return jsonMap;

        } else {
            jsonMap.put("state","no");
            return jsonMap;
        }
    }

         @RequestMapping(value = "/rootApply",method = RequestMethod.GET)
        public String rootApply(Model model,HttpSession session) {
            String name = (String) session.getAttribute("username");
            model.addAttribute("name", name);
            String state="待审核";
            PageHelper.startPage(1,9);
            try {
                List<Maintain> userList=maintainService.SelectAll(state);
                if(userList!=null) {
                    PageInfo<Maintain> pageInfo = new PageInfo<>(userList);
                    model.addAttribute("maintains", userList);
                    model.addAttribute("pageInfo", pageInfo);
                   return "rootApply";
                }
                else {
                    Maintain maintain2=new Maintain();
                    maintain2.setContent("---");
                    maintain2.setPhone("---");
                    maintain2.setName("---");
                    maintain2.setSnub("---");
                    maintain2.setLnub("---");
                    maintain2.setXi("---");
                    maintain2.setClas("---");
                    maintain2.setState("---");
                    maintain2.setId(0);
                    model.addAttribute("maintains",maintain2);
                    return "rootApply";
                }
            }
            finally {
                PageHelper.clearPage();
            }


        }
    @RequestMapping(value = "/rootApply_Success",method = RequestMethod.GET)
    public String rootApply_success(Model model,HttpSession session) {
        String name = (String) session.getAttribute("username");
        model.addAttribute("name", name);
        String state="已通过";
        PageHelper.startPage(1,9);
        try {
            List<Maintain> userList=maintainService.SelectAll(state);
            if(userList!=null) {
                PageInfo<Maintain> pageInfo = new PageInfo<>(userList);
                model.addAttribute("maintains", userList);
                model.addAttribute("pageInfo", pageInfo);
                return "rootApply_Success";
            }
            else {
                Maintain maintain2=new Maintain();
                maintain2.setContent("---");
                maintain2.setPhone("---");
                maintain2.setName("---");
                maintain2.setSnub("---");
                maintain2.setLnub("---");
                maintain2.setXi("---");
                maintain2.setClas("---");
                maintain2.setState("---");
                maintain2.setId(0);
                model.addAttribute("maintains",maintain2);
                return "rootApply_Success";
            }
        }
        finally {
            PageHelper.clearPage();
        }


    }
    @RequestMapping(value = "/rootApply_Return",method = RequestMethod.GET)
    public String rootApply_Return(Model model,HttpSession session) {
        String name = (String) session.getAttribute("username");
        model.addAttribute("name", name);
        String state="已驳回";
        PageHelper.startPage(1,9);
        try {
            List<Maintain> userList=maintainService.SelectAll(state);
            if(userList!=null) {
                PageInfo<Maintain> pageInfo = new PageInfo<>(userList);
                model.addAttribute("maintains", userList);
                model.addAttribute("pageInfo", pageInfo);
                return "rootApply_Return";
            }
            else {
                Maintain maintain2=new Maintain();
                maintain2.setContent("---");
                maintain2.setPhone("---");
                maintain2.setName("---");
                maintain2.setSnub("---");
                maintain2.setLnub("---");
                maintain2.setXi("---");
                maintain2.setClas("---");
                maintain2.setState("---");
                maintain2.setId(0);
                model.addAttribute("maintains",maintain2);
                return "rootApply_Return";
            }
        }
        finally {
            PageHelper.clearPage();
        }


    }
        @RequestMapping(value = "/rootApply/PageSelectAll", method = RequestMethod.GET)
    public String PageSelect(int pageNum,HttpSession session,Model model) {
        String name = (String) session.getAttribute("username");
        model.addAttribute("name", name);
        String state="待审核";
        PageHelper.startPage(pageNum,9);
        try {
            List<Maintain> userList=maintainService.SelectAll(state);
            if(userList!=null) {
                PageInfo<Maintain> pageInfo = new PageInfo<>(userList);
                model.addAttribute("maintains", userList);
                model.addAttribute("pageInfo", pageInfo);
                return "rootApply";
            }
            else {
                Maintain maintain2=new Maintain();
                maintain2.setContent("---");
                maintain2.setPhone("---");
                maintain2.setName("---");
                maintain2.setSnub("---");
                maintain2.setLnub("---");
                maintain2.setXi("---");
                maintain2.setClas("---");
                maintain2.setState("---");
                maintain2.setId(0);
                model.addAttribute("maintains",maintain2);
                return "rootApply";
            }
        }
        finally {
            PageHelper.clearPage();
        }

    }
    @RequestMapping(value = "/rootApply_Success/PageSelectAll", method = RequestMethod.GET)
    public String PageSelect_Success(int pageNum,HttpSession session,Model model) {
        String name = (String) session.getAttribute("username");
        model.addAttribute("name", name);
        String state="已通过";
        PageHelper.startPage(pageNum,9);
        try {
            List<Maintain> userList=maintainService.SelectAll(state);
            if(userList!=null) {
                PageInfo<Maintain> pageInfo = new PageInfo<>(userList);
                model.addAttribute("maintains", userList);
                model.addAttribute("pageInfo", pageInfo);
                return "rootApply_Success";
            }
            else {
                Maintain maintain2=new Maintain();
                maintain2.setContent("---");
                maintain2.setPhone("---");
                maintain2.setName("---");
                maintain2.setSnub("---");
                maintain2.setLnub("---");
                maintain2.setXi("---");
                maintain2.setClas("---");
                maintain2.setState("---");
                maintain2.setId(0);
                model.addAttribute("maintains",maintain2);
                return "rootApply_Success";
            }
        }
        finally {
            PageHelper.clearPage();
        }

    }
    @RequestMapping(value = "/rootApply_Return/PageSelectAll", method = RequestMethod.GET)
    public String PageSelect_Return(int pageNum,HttpSession session,Model model) {
        String name = (String) session.getAttribute("username");
        model.addAttribute("name", name);
        String state="已驳回";
        PageHelper.startPage(pageNum,9);
        try {
            List<Maintain> userList=maintainService.SelectAll(state);
            if(userList!=null) {
                PageInfo<Maintain> pageInfo = new PageInfo<>(userList);
                model.addAttribute("maintains", userList);
                model.addAttribute("pageInfo", pageInfo);
                return "rootApply_Return";
            }
            else {
                Maintain maintain2=new Maintain();
                maintain2.setContent("---");
                maintain2.setPhone("---");
                maintain2.setName("---");
                maintain2.setSnub("---");
                maintain2.setLnub("---");
                maintain2.setXi("---");
                maintain2.setClas("---");
                maintain2.setState("---");
                maintain2.setId(0);
                model.addAttribute("maintains",maintain2);
                return "rootApply_Return";
            }
        }
        finally {
            PageHelper.clearPage();
        }

    }
    @RequestMapping(value = "/rootLeave/PageSelectAll", method = RequestMethod.GET)
    public String PageSelect_Leave(int pageNum,HttpSession session,Model model) {
        String name = (String) session.getAttribute("username");
        model.addAttribute("name", name);
        PageHelper.startPage(pageNum,9);
        try {
            List<Leave> userList=leaveService.SelectStudent_LeaveAll();
            if(userList!=null) {
                PageInfo<Leave> pageInfo = new PageInfo<>(userList);
                model.addAttribute("leaves", userList);
                model.addAttribute("pageInfo", pageInfo);
                return "rootLeave";
            }
            else {
                Maintain maintain2=new Maintain();
                maintain2.setContent("---");
                maintain2.setPhone("---");
                maintain2.setName("---");
                maintain2.setSnub("---");
                maintain2.setLnub("---");
                maintain2.setXi("---");
                maintain2.setClas("---");
                maintain2.setState("---");
                maintain2.setId(0);
                model.addAttribute("maintains",maintain2);
                return "rootLeave";
            }
        }
        finally {
            PageHelper.clearPage();
        }

    }
        @RequestMapping(value = "/SelectById_NoState", method = RequestMethod.GET)
        @ResponseBody
        public  Object SelectById_NoState(String state,String clas, ModelMap map,Model model, HttpSession session) {
            Map<String,Object> jsonMap = new HashMap<String,Object>();
            String name = (String) session.getAttribute("username");
            model.addAttribute("name", name);
            List<Maintain> maintain=maintainService.SelectById_NoState(clas,state);
            if(null!=maintain && maintain.size() > 0 ){
                jsonMap.put("maintain",maintain);
                jsonMap.put("state",1);
                return jsonMap;
            }
            else {
                jsonMap.put("state",2);
                return jsonMap;
            }
        }
    @RequestMapping(value = "/SelectMaintain_tableXiById", method = RequestMethod.GET)
    @ResponseBody
    public  Object SelectMaintain_tableXiById(String state,String xi, ModelMap map,Model model, HttpSession session) {
        Map<String,Object> jsonMap = new HashMap<String,Object>();
        String name = (String) session.getAttribute("username");
        model.addAttribute("name", name);
        List<Maintain> maintain=maintainService.SelectMaintain_tableXiById(xi,state);
        if(null!=maintain && maintain.size() > 0 ){
            jsonMap.put("maintain",maintain);
            jsonMap.put("state",1);
            return jsonMap;
        }
        else {
            jsonMap.put("state",2);
            return jsonMap;
        }
    }
    @RequestMapping(value = "/SelectMaintain_table_LById", method = RequestMethod.GET)
    @ResponseBody
    public  Object SelectMaintain_table_LById(String state,String lnub, ModelMap map,Model model, HttpSession session) {
        Map<String,Object> jsonMap = new HashMap<String,Object>();
        String name = (String) session.getAttribute("username");
        model.addAttribute("name", name);
        List<Maintain> maintain=maintainService.SelectMaintain_table_LById(lnub,state);
        if(null!=maintain && maintain.size() > 0 ){
            jsonMap.put("maintain",maintain);
            jsonMap.put("state",1);
            return jsonMap;
        }
        else {
            jsonMap.put("state",2);
            return jsonMap;
        }
    }
    @RequestMapping(value = "/UpdateStateByReturn", method = RequestMethod.GET)
    public String UpdateStateByReturn(int id,HttpSession session,Model model) {
        int i=maintainService.UpdateStateByReturn(id);
        String name = (String) session.getAttribute("username");
        model.addAttribute("name", name);
        String state="待审核";
        PageHelper.startPage(1,9);
        try {
            List<Maintain> userList=maintainService.SelectAll(state);
            if(userList!=null) {
                PageInfo<Maintain> pageInfo = new PageInfo<>(userList);
                model.addAttribute("maintains", userList);
                model.addAttribute("pageInfo", pageInfo);
                return "rootApply";
            }
            else {
                Maintain maintain2=new Maintain();
                maintain2.setContent("---");
                maintain2.setPhone("---");
                maintain2.setName("---");
                maintain2.setSnub("---");
                maintain2.setLnub("---");
                maintain2.setXi("---");
                maintain2.setClas("---");
                maintain2.setState("---");
                maintain2.setId(0);
                model.addAttribute("maintains",maintain2);
                return "rootApply";
            }
        }
        finally {
            PageHelper.clearPage();
        }
    }
        @RequestMapping(value = "/rootDelete", method = RequestMethod.GET)
        public String rootDelete(int id,HttpSession session,Model model) {
            int i=maintainService.DeleteById(id);
            String name = (String) session.getAttribute("username");
            model.addAttribute("name", name);
            String state="待审核";
            PageHelper.startPage(1,9);
            try {
                List<Maintain> userList=maintainService.SelectAll(state);
                if(userList!=null) {
                    PageInfo<Maintain> pageInfo = new PageInfo<>(userList);
                    model.addAttribute("maintains", userList);
                    model.addAttribute("pageInfo", pageInfo);
                    return "rootApply";
                }
                else {
                    Maintain maintain2=new Maintain();
                    maintain2.setContent("---");
                    maintain2.setPhone("---");
                    maintain2.setName("---");
                    maintain2.setSnub("---");
                    maintain2.setLnub("---");
                    maintain2.setXi("---");
                    maintain2.setClas("---");
                    maintain2.setState("---");
                    maintain2.setId(0);
                    model.addAttribute("maintains",maintain2);
                    return "rootApply";
                }
            }
            finally {
                PageHelper.clearPage();
            }
        }
    @RequestMapping(value = "/rootDelete_Success", method = RequestMethod.GET)
    public String rootDelete_Success(int id,HttpSession session,Model model) {
        int i=maintainService.DeleteById(id);
        String name = (String) session.getAttribute("username");
        model.addAttribute("name", name);
        String state="已通过";
        PageHelper.startPage(1,9);
        try {
            List<Maintain> userList=maintainService.SelectAll(state);
            if(userList!=null) {
                PageInfo<Maintain> pageInfo = new PageInfo<>(userList);
                model.addAttribute("maintains", userList);
                model.addAttribute("pageInfo", pageInfo);
                return "rootApply_Success";
            }
            else {
                Maintain maintain2=new Maintain();
                maintain2.setContent("---");
                maintain2.setPhone("---");
                maintain2.setName("---");
                maintain2.setSnub("---");
                maintain2.setLnub("---");
                maintain2.setXi("---");
                maintain2.setClas("---");
                maintain2.setState("---");
                maintain2.setId(0);
                model.addAttribute("maintains",maintain2);
                return "rootApply_Success";
            }
        }
        finally {
            PageHelper.clearPage();
        }
    }
    @RequestMapping(value = "/rootDelete_Return", method = RequestMethod.GET)
    public String rootDelete_Return(int id,HttpSession session,Model model) {
        int i=maintainService.DeleteById(id);
        String name = (String) session.getAttribute("username");
        model.addAttribute("name", name);
        String state="已驳回";
        PageHelper.startPage(1,9);
        try {
            List<Maintain> userList=maintainService.SelectAll(state);
            if(userList!=null) {
                PageInfo<Maintain> pageInfo = new PageInfo<>(userList);
                model.addAttribute("maintains", userList);
                model.addAttribute("pageInfo", pageInfo);
                return "rootApply_Return";
            }
            else {
                Maintain maintain2=new Maintain();
                maintain2.setContent("---");
                maintain2.setPhone("---");
                maintain2.setName("---");
                maintain2.setSnub("---");
                maintain2.setLnub("---");
                maintain2.setXi("---");
                maintain2.setClas("---");
                maintain2.setState("---");
                maintain2.setId(0);
                model.addAttribute("maintains",maintain2);
                return "rootApply_Return";
            }
        }
        finally {
            PageHelper.clearPage();
        }
    }
    @RequestMapping(value = "/SelectById_rootApply", method = RequestMethod.GET)
    @ResponseBody
    public  Object SelectById_rootApply(int id, ModelMap map,Model model, HttpSession session) {
        Map<String,Object> jsonMap = new HashMap<String,Object>();
        String name = (String) session.getAttribute("username");
        model.addAttribute("name", name);
       Maintain maintain=maintainService.SelectById_rootApply(id);
        if(null!=maintain){
            jsonMap.put("maintain",maintain);
            jsonMap.put("state",1);
            return jsonMap;
        }
        else {
            jsonMap.put("state",2);
            return jsonMap;
        }
    }
//    @RequestMapping(value = "/PageSelectMaster", method = RequestMethod.GET)
//    public String PageSelectMaster(int id,HttpSession session,Model model) {
//        int pageStart=7*(id-1);
//        int pageEnd=7*id;
//        String name=(String)session.getAttribute("username");
//        model.addAttribute("name",name);
//        List<Marster> master=masterService.PageSelectMaster(pageStart,pageEnd);
//        if(null!=master&&master.size()>0){
//            model.addAttribute("masters",master);
//        }
//        return "rootPhone";
//    }
    @RequestMapping(value = "/PageSelectMaster", method = RequestMethod.GET)
    public String PageSelectMaster(Integer pageNum,HttpSession session,Model model) {
        PageHelper.startPage(pageNum,7);
       try {
           List<Marster> userList = masterService.SelectAll();
           PageInfo<Marster> pageInfo = new PageInfo<>(userList);
           model.addAttribute("masters",userList);
           model.addAttribute("pageIfo",pageInfo);
           return "rootPhone";
       }
       finally {
           PageHelper.clearPage();
       }

    }
    @RequestMapping(value = "/SelectAllByName", method = RequestMethod.POST)
    @ResponseBody
    public Object SelectAllByName(String name,HttpSession session,Model model) {
        Map<String,Object> jsonMap = new HashMap<String,Object>();
        List<Marster>  master=masterService.SelectAllByName(name);
        if(master!=null){
            jsonMap.put("Masters",master);
            jsonMap.put("state",1);
        }
       else {
            jsonMap.put("state",0);
        }
        return  jsonMap;
    }
    @RequestMapping(value = "/DeleteLeaveSomeById", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object>  DeleteSomeById(int[] array,HttpSession session, Model model) {
        Map<String,Object> jsonMap = new HashMap<String,Object>();
        int i=leaveService.DeleteSomeById(array);
        if(i!=0){
            jsonMap.put("state",1);
        }
        else {
            jsonMap.put("state",0);
        }
        return jsonMap;
    }
    @RequestMapping(value = "/DeleteLeaveByRoot", method = RequestMethod.GET)
    public String  DeleteLeaveByMe(int id,HttpSession session,Model model) {
        String number=(String)session.getAttribute("number");
        String name=(String)session.getAttribute("username");
        model.addAttribute("name",name);
        leaveService.DeleteLeaveByRoot(id);
        List<Leave> leaves=leaveService.SelectByRootAll();
        model.addAttribute("leaves",leaves);
        return "rootLeave_Return";
    }
}
