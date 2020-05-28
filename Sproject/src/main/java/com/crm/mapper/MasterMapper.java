package com.crm.mapper;

import com.crm.dao.Marster;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MasterMapper {
    List<Marster> SelectAll();
    List<Marster> SelectAllByName(String name);
    List<Marster> SelectAllByLimit();
    int DellMasterById(int id);
    int UpdateMasterById(Marster marster);
    int InsertMaster(Marster marster);
    int CountMaster();
    List<Marster> PageSelectMaster(int id,int idE);



}
