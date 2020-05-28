package com.crm.servise;

import com.crm.dao.Maintain;

import java.util.List;
import java.util.Map;

public interface MaintainService {
    void Insert(Maintain maintain);
    List<Maintain> SelectByName(String clas);
    List<Maintain> SelectByState(String clas);
    int DeleteById (int id);
    int DeleteSomeById(int[] AnyId);
    List<Maintain> SelectByPage(String number,int id,int idE);
    List<Maintain> SelectAllLimit();
    List<Maintain> SelectAll(String state);
    List<Maintain> SelectByPageAll(int id,int idE);
    List<Maintain> SelectById_NoState(String clas,String state);
    List<Maintain> SelectMaintain_tableXiById(String xi,String state);
    List<Maintain> SelectMaintain_table_LById(String lou_id,String state);
    Maintain  SelectById_rootApply(int id);
    List<String> SelectStateByName(String clas);
    List<Maintain> SelectMaintainByLikeTime(String time,String number);
    int UpdateStateByReturn(int id);
}
