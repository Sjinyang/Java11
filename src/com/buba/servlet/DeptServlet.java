package com.buba.servlet;

import com.buba.entiy.Dept;

import java.util.List;

public interface DeptServlet {
    List<Dept> finAllDept();
    Dept editById(Integer editById);
    int editSoldier(Dept dept);
    int addSoldier(Dept dept);
}
