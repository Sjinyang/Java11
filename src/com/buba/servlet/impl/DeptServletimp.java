package com.buba.servlet.impl;

import com.buba.dao.DeptDao;
import com.buba.dao.impl.DeptDaoimpl;
import com.buba.entiy.Dept;
import com.buba.servlet.DeptServlet;

import java.util.List;

public class DeptServletimp implements DeptServlet {
    private DeptDao deptDao = new DeptDaoimpl();
    @Override
    public List<Dept> finAllDept() {
        return deptDao.finAllDept();
    }

    @Override
    public Dept editById(Integer editById) {
        return deptDao.editById(editById);
    }

    @Override
    public int editSoldier(Dept dept) {
        return deptDao.editSoldier(dept);
    }

    @Override
    public int addSoldier(Dept dept) {
        return deptDao.addSoldier(dept);
    }
}
