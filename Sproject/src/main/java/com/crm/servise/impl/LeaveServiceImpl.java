package com.crm.servise.impl;

import com.crm.dao.Leave;
import com.crm.mapper.LeaveMapper;
import com.crm.servise.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    private LeaveMapper leaveMapper;
    @Override
    public int InsertLeave_table(Leave leave){
        return leaveMapper.InsertLeave_table(leave);
    }
    public List<Leave> SelectByNumber(String number){
        return leaveMapper.SelectByNumber(number);
    }
    public List<Leave> SelectByTo_id(String number){
        return leaveMapper.SelectByTo_id(number);
    }
    public  int  DeleteLeaveByMe(int id){
    return leaveMapper.DeleteLeaveByMe(id);
    }
    public  List<Leave> SelectStudent_LeaveAll(){
        return leaveMapper.SelectStudent_LeaveAll();
    }
    public  int DeleteSomeById(int[] AnyId){
        return leaveMapper.DeleteSomeById(AnyId);
    }
    public List<Leave> SelectByRootAll(){
        return leaveMapper.SelectByRootAll();
    }
    public  int UpDateLeaveByBack(int id){
        return leaveMapper.UpDateLeaveByBack(id);
    }
    public  List<Leave> SelectLeaveByBack(String back){
        return leaveMapper.SelectLeaveByBack(back);
    }
    public  int DeleteLeaveByRoot(int id){
        return leaveMapper.DeleteLeaveByRoot(id);
    }
}
