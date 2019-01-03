package com.china.only.teacher.service.impl;

import com.china.only.teacher.dao.TeacherDao;
import com.china.only.teacher.model.Lesson;
import com.china.only.teacher.service.TeachService;
import org.springframework.stereotype.Component;

import java.util.List;

public class TeachServiceImpl implements TeachService {

    private TeacherDao dao = null;
    private String id = null;
    private int code;
    private boolean isHere;

    @Override
    public List<Lesson> hasLessons() {
        return dao.queryOwnLessons();
    }


    //////setter方法
    public void setDao(TeacherDao dao) {
        this.dao = dao;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setHere(boolean here) {
        isHere = here;
    }
}
