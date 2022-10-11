package com.buba.dao;

import com.buba.entiy.Dept;

import java.util.List;

public interface DeptDao {
    List<Dept> finAllDept();
    Dept editById(Integer editById);
    int editSoldier(Dept dept);
    int addSoldier(Dept dept);
}
