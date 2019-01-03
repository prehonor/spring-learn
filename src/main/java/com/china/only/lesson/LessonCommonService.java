package com.china.only.lesson;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class LessonCommonService {

    public void lessonMethod(){
        System.out.println("LessonCommonService::lessonMethod ");
    }
}
