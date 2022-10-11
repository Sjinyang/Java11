package com.buba.dao.impl;

import com.buba.dao.DeptDao;
import com.buba.entiy.Dept;
import com.buba.utills.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DeptDaoimpl implements DeptDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
    @Override
    public List<Dept> finAllDept() {
        String sql = "select * from department ";
        List<Dept> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Dept.class));
        return query;
    }

    @Override
    public Dept editById(Integer editById) {
        String sql = "select * from department where dept_id =?";
        Dept dept = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Dept.class), editById);
        return dept;
    }

    @Override
    public int editSoldier(Dept dept) {

        String sql = "update department set dept_number = ?, dept_name = ?, province = ?, people_counting = ?, described = ? where dept_id = ?";
        int i = jdbcTemplate.update(sql, dept.getDeptNumber(), dept.getDeptName(), dept.getProvince(), dept.getPeopleCounting(), dept.getDescribed(), dept.getDeptId());
        return i;
    }

    @Override
    public int addSoldier(Dept dept) {

        String sql = "insert into department  values(?,?,?,?,?,?)";
        int update = jdbcTemplate.update(sql, dept.getDeptId(), dept.getDeptNumber(),dept.getDeptName(),dept.getProvince(),dept.getPeopleCounting(),dept.getDescribed());
        return update;
    }
}
