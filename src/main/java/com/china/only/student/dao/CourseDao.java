package com.china.only.student.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class CourseDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addHouse() {
        String sql = "insert into house (name, price) values(?,?)";
        int rows = jdbcTemplate.update(sql,"家乐福",299.0);
    }

    public void addCustomer(){
        String sql1 = "insert into shoe (name, price) values(?,?)";
        int rows1 = jdbcTemplate.update(sql1,"姚明火箭系列",99999);
        String sql2 = "insert into customer (name, contrrract) values(?,?)";
        int rows2 = jdbcTemplate.update(sql2,"李帅","萧陌");
    }

    public void addLog(){
        String sql = "insert into log(describe) values(?)";
        int rows = jdbcTemplate.update(sql,"这是一条日志记录",1);
    }

    public void addSysUser(){
        String sql = "insert into sys_user(user_name,user_password,user_email,user_info,head_img,create_time) values(?,?,?,?,?,?)";
        int rows = jdbcTemplate.update(sql,"陈平", "123456", "admin@mybatis.tk", "管理员用户", 0x023661530, "2016-06-07 01:11:12");
    }

    public void addRole(){
        String sql = "insert into sys_role(role_name,enabled,create_by,create_time) values(?,?,?,?)";
        int rows = jdbcTemplate.update(sql,"总统", 1,  1 , "2018-06-07 01:11:12");
    }

    public void addPrivilege(){
        String sql1 = "insert into shoe (name, price) values(?,?)";
        int rows1 = jdbcTemplate.update(sql1,"姚明火箭系列",99999);
        String sql = "insert into sys_privilege(privilege_name,privilege_url) values(?,?)";
        int rows = jdbcTemplate.update(sql, "车辆维护","/cars");//,1
    }

}
