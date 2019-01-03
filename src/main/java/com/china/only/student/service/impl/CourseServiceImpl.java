package com.china.only.student.service.impl;

import com.china.only.student.dao.CourseDao;
import com.china.only.student.service.CourseService;
import org.springframework.aop.framework.AopContext;

public class CourseServiceImpl implements CourseService {

    private CourseDao dao;
    public void setCourseDao(CourseDao courseDao) {
        this.dao = courseDao;
    }
    @Override
    public String queryCourse(String name) {
        System.out.println("invoke "+ "体育课");
        return "体育课";
    }

    @Override
    public void registryCourse(String name) {
        System.out.println("修习该课程:" + name);
        try{
            CourseService thizz = (CourseService)AopContext.currentProxy();
            thizz.registryMe("张无忌");
        }catch (Exception e){
            //do nothing
        }
        dao.addHouse();
    }

    @Override
    public void registryMe(String name) {
        System.out.println("登记我自己:" + name);
        dao.addCustomer();
    }

    @Override
    public void recordLog() {
        System.out.println("记录一条日志");
        dao.addLog();

    }

    @Override
    public void addUser() {
        System.out.println("添加系统用户");
        try{
            CourseService thizz = (CourseService)AopContext.currentProxy();
            thizz.recordLog();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        dao.addSysUser();
    }

    @Override
    public void addRole() {
        System.out.println("添加系统用户");
        dao.addHouse();
        try{
            CourseService thizz = (CourseService)AopContext.currentProxy();
            thizz.addPrivilege();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        dao.addRole();
    }

    @Override
    public void addPrivilege() {
        dao.addPrivilege();
    }

}
