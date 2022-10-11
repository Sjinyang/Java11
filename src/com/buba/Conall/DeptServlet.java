package com.buba.Conall;

import com.buba.entiy.Dept;
import com.buba.servlet.impl.DeptServletimp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DeptServlet extends ViewBaseServlet{
    private DeptServletimp DeptService = new DeptServletimp();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        if ("finAllDept".equals(req.getParameter("method").toString())){
            this.finAllDept(req, resp);
        }

        if ("DeptJump".equals(req.getParameter("method").toString())){
            this.DeptJump(req, resp);
        }
        if ("editSoldier".equals(req.getParameter("method").toString())){
            this.editSoldier(req, resp);
        }
        if ("addSoldier".equals(req.getParameter("method").toString())){
            this.addSoldier(req, resp);
        }
    }

    private void addSoldier(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException {
        String aid = req.getParameter("aid");
        String aweapon = req.getParameter("anumber");
        String aname = req.getParameter("aname");
        String aprovince = req.getParameter("aprovince");
        String acounting = req.getParameter("acounting");
        String aibed = req.getParameter("aibed");
        Dept dept = new Dept(Integer.valueOf(aid), aweapon, aname, aprovince, Integer.valueOf(acounting), aibed);
        DeptService.addSoldier(dept);

        this.finAllDept(req, resp);
    }

    private void editSoldier(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException {
        String aid = req.getParameter("aid");
        String aweapon = req.getParameter("anumber");
        String aname = req.getParameter("aname");
        String aprovince = req.getParameter("aprovince");
        String acounting = req.getParameter("acounting");
        String aibed = req.getParameter("aibed");


        Dept soldier = new Dept(Integer.valueOf(aid ), aweapon, aname,aprovince,Integer.valueOf(acounting),aibed);
        System.out.println(soldier);
        DeptService.editSoldier(soldier);
        this.finAllDept(req, resp);
    }

    private void DeptJump(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException  {
        String[] abcs = req.getParameterValues("abc");


        if (abcs != null) {
            for (String abc : abcs) {
                if(abc.equals("修改")){
                    String[] ids = req.getParameterValues("id");
                    for (String id : ids) {
                        Dept dept = DeptService.editById(Integer.valueOf(id));
                        req.setAttribute("dept",dept);
                        System.out.println(dept);
                    }

                    processTemplate("edit",req,resp);

                }
                if(abc.equals("创建")){

                    processTemplate("add",req,resp);
                }
                if(abc.equals("删除")){

                }
            }
        }else{
            this.finAllDept(req,resp);
        }

    }

    private void finAllDept(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException {
        List<Dept> count = DeptService.finAllDept();
        req.setAttribute("soldiers",count);

        processTemplate("list",req,resp);
    }

}
