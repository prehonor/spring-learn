package com.china.only.teacher.dao.impl;

import com.china.only.teacher.dao.TeacherDao;
import com.china.only.teacher.model.Lesson;

import java.util.List;

public class TeacherDaoImpl implements TeacherDao {

    @Override
    public List<Lesson> queryOwnLessons() {
        System.out.println("从数据库中查询教授的课程");
        return null;
    }
}
