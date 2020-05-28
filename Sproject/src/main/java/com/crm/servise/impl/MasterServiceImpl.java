package com.crm.servise.impl;

import com.crm.dao.Maintain;
import com.crm.dao.Marster;
import com.crm.mapper.MasterMapper;
import com.crm.servise.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterServiceImpl implements MasterService {
    @Autowired
   private MasterMapper masterMapper;
    @Override
    public List<Marster> SelectAll(){
        return masterMapper.SelectAll();
    }
    public int DellMasterById(int id){
        return masterMapper.DellMasterById(id);
    }
    public int UpdateMasterById(Marster marster){
        return masterMapper.UpdateMasterById(marster);
    }
    public  int InsertMaster(Marster marster){
        return masterMapper.InsertMaster(marster);
    }
    public  int CountMaster(){
        return masterMapper.CountMaster();
    }
    public  List<Marster> SelectAllByLimit(){
        return masterMapper.SelectAllByLimit();
    }
    public  List<Marster> PageSelectMaster(int id,int idE){
        return masterMapper.PageSelectMaster(id,idE);
    }
    public   List<Marster> SelectAllByName(String name){
        return  masterMapper.SelectAllByName(name);
    }
}
