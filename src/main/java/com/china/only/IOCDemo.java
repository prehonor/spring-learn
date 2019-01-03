package com.china.only;


import com.china.only.configuration.ConfigMovie;
import com.china.only.configuration.TestConfiguration;
import com.china.only.configuration.movie.MovieInfoService;
import com.china.only.configuration.movie.TicketSaleService;
import com.china.only.lesson.LessonCommonService;
import com.china.only.lesson.LessonInfoService;
import com.china.only.teacher.service.impl.TeachServiceImpl;
import com.china.only.user.service.impl.LoginServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;

public class IOCDemo {
    public static void main( String[] args )
    {
//        testMyBean();
//        testInject();
//        testScan();
//        testScanInject();
        testConfigurationClass();
    }

    public static void testMyBean(){
        AbstractApplicationContext aContext = new ClassPathXmlApplicationContext("beans-ioc.xml");
        LoginServiceImpl loginService = (LoginServiceImpl) aContext.getBean("loginServiceImpl");
        try {
            loginService.login(new HashMap<>());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 基于XML的依赖注入
     * */
    public static void testInject(){
        AbstractApplicationContext aContext = new ClassPathXmlApplicationContext("beans-inject.xml");
        TeachServiceImpl teachService = (TeachServiceImpl) aContext.getBean("teachServiceImpl");
        teachService.hasLessons();
    }

    public static void testScan(){
        AbstractApplicationContext aContext = new ClassPathXmlApplicationContext("beans-scan.xml");
        LessonCommonService lessonCommonService = (LessonCommonService) aContext.getBean("lesson");
        lessonCommonService.lessonMethod();
    }

    public static void testScanInject(){
        AbstractApplicationContext aContext = new ClassPathXmlApplicationContext("beans-scan.xml");
        LessonInfoService lessonInfoServiceImpl = (LessonInfoService) aContext.getBean("lesson");
        lessonInfoServiceImpl.lessonInfo();
    }

    public static void testConfigurationClass(){
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration.class);
        ConfigMovie configMovie = (ConfigMovie)context.getBean("configMovie");
        configMovie.uploadMovie();
        MovieInfoService movieInfoService = (MovieInfoService)context.getBean("movieInfoService");
        movieInfoService.getMovieInfo();
        TicketSaleService ticketSaleService = (TicketSaleService)context.getBean("ticketSaleService");
        ticketSaleService.saler();
    }
}
