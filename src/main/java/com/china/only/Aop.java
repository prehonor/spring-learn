package com.china.only;

import com.china.only.student.service.CourseService;
import com.china.only.user.service.LoginService;
import com.china.only.user.service.LoginService;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class Aop
{
    public static void main( String[] args )
    {
//        testMyTransation();
//        testMyAOP();
//        testAOPConfig();
//        testTransRollBack();
        testTransRollBack2();
//        testTransRollBack3();
    }

    public static void testMyTransation(){
        AbstractApplicationContext aContext = new ClassPathXmlApplicationContext("beans-trans.xml");
        CourseService courseService = (CourseService) aContext.getBean("courseServiceWithTrans");
        String name = courseService.queryCourse("体育课");
    }


    public static void testMyAOP(){
        ClassPathResource resource = new ClassPathResource("beans-aop.xml");
        DefaultListableBeanFactory aContext = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(aContext);
        reader.loadBeanDefinitions(resource);
        LoginService service = (LoginService) aContext.getBean("myAOP");
        Map<String,Object> params = new HashMap<String,Object>();
        try {
            service.login(params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //使用Spring提供的 TransactionProxyFactoryBean类的事务
    public static void testAOPConfig(){
        AbstractApplicationContext factory = new ClassPathXmlApplicationContext("beans-trans.xml");
        CourseService courseService = (CourseService) factory.getBean("courseService");
        courseService.queryCourse("英语课");
    }

    //测试事务的传播行为 PROPAGATION_REQUIRED
    public static void testTransRollBack(){
        AbstractApplicationContext aContext = new ClassPathXmlApplicationContext("beans-trans-roll.xml");
        CourseService courseService = (CourseService) aContext.getBean("courseServiceWithTrans");
        courseService.registryCourse("生理课");
        System.out.println("");
    }

    //测试事务的传播行为 PROPAGATION_REQUIRES_NEW
    public static void testTransRollBack2(){
        AbstractApplicationContext aContext = new ClassPathXmlApplicationContext("beans-trans-roll.xml");
        CourseService courseService = (CourseService) aContext.getBean("courseServiceWithTrans");
        courseService.addUser();
        System.out.println("");
    }

    //测试事务的传播行为 PROPAGATION_NESTED
    public static void testTransRollBack3(){
        AbstractApplicationContext aContext = new ClassPathXmlApplicationContext("beans-trans-roll.xml");
        CourseService courseService = (CourseService) aContext.getBean("courseServiceWithTrans");
        courseService.addRole();
        System.out.println("");
    }
}
