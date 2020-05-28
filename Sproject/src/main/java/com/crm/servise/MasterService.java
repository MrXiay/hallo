package com.crm.servise;

import com.crm.dao.Marster;

import java.util.List;

public interface MasterService {
    List<Marster> SelectAll();
    List<Marster> SelectAllByName(String name);
    int DellMasterById(int id);
    int UpdateMasterById(Marster marster);
    int InsertMaster(Marster marster);
    int CountMaster();
    List<Marster> SelectAllByLimit();
    List<Marster> PageSelectMaster(int id,int idE);
}
