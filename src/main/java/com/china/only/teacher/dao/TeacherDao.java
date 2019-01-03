package com.china.only.teacher.dao;

import com.china.only.teacher.model.Lesson;

import java.util.List;

public interface TeacherDao {
    public List<Lesson> queryOwnLessons();
}
