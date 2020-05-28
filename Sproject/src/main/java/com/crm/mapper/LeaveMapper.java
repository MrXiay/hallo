package com.crm.mapper;

import com.crm.dao.Leave;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LeaveMapper {
 int InsertLeave_table(Leave leave);
 List<Leave> SelectByNumber(String number);
 List<Leave> SelectByTo_id(String number);
  int  DeleteLeaveByMe(int id);
  List<Leave> SelectStudent_LeaveAll();
 int DeleteSomeById(int[] AnyId);
 List<Leave> SelectByRootAll();
 int UpDateLeaveByBack(int id);
 List<Leave> SelectLeaveByBack(String back);
 int DeleteLeaveByRoot(int id);
}
