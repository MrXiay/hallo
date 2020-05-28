package com.crm.servise.impl;

import com.crm.dao.Maintain;
import com.crm.mapper.MaintainMapper;
import com.crm.servise.MaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MaintainServiceImpl implements MaintainService {
    @Autowired
   private  MaintainMapper maintainMapper;
    @Override
    public void Insert(Maintain maintain){
        maintainMapper.Insert(maintain);
    }
    public List<Maintain> SelectByName(String clas){
        return maintainMapper.SelectByName(clas);
    }
    public List<Maintain> SelectByState(String clas){
        return maintainMapper.SelectByState(clas);
    }
    public int DeleteById(int id){
        return maintainMapper.DeleteById(id);
    }
    public  List<Maintain> SelectByPage(String number,int id,int idE){
        return maintainMapper.SelectByPage(number,id,idE);
    }
    public  List<Maintain> SelectAll(String state){
        return maintainMapper.SelectAll(state);
    }
    public List<Maintain> SelectByPageAll(int id,int idE){
        return maintainMapper.SelectByPageAll(id,idE);
    }
    public List<Maintain> SelectById_NoState(String clas,String state){
     return maintainMapper.SelectById_NoState(clas,state);
    }
    public Maintain  SelectById_rootApply(int id){
        return maintainMapper.SelectById_rootApply(id);
    }
    public List<String> SelectStateByName(String clas){
        return maintainMapper.SelectStateByName(clas);
    }
    public List<Maintain> SelectAllLimit(){
        return maintainMapper.SelectAllLimit();
    }
    public  int DeleteSomeById(int[] AnyId){
        return maintainMapper.DeleteSomeById(AnyId);
    }
    public  List<Maintain> SelectMaintain_tableXiById(String xi,String state){
        return maintainMapper.SelectMaintain_tableXiById(xi,state);
    }
    public  List<Maintain> SelectMaintain_table_LById(String lou_id,String state){
        return maintainMapper.SelectMaintain_table_LById(lou_id,state);
    }
    public  List<Maintain> SelectMaintainByLikeTime(String time,String number){
        return maintainMapper.SelectMaintainByLikeTime(time,number);
    }
    public int UpdateStateByReturn(int id){
        return maintainMapper.UpdateStateByReturn(id);
    }
}
