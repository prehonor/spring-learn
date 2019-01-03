package com.china.only.lesson.impl;

import com.china.only.lesson.LessonInfoService;
import com.china.only.lesson.dao.LessonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("lesson")
public class LessonInfoServiceImpl implements LessonInfoService {

    @Autowired
    LessonDao dao;

    @Override
    public void lessonInfo() {
        dao.queryLessons();
    }

}
