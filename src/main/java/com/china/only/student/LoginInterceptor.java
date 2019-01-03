package com.china.only.student;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoginInterceptor {
    public void doAccessCheck() {
        System.out.println("前置通知-->>");
    }

    public void doAfterReturning() {
        System.out.println("后置通知-->>");
    }

    public void doAfter() {
        System.out.println("最终通知");
    }

    public void doAfterThrowing() {
        System.out.println("异常通知-->");
    }

    public Object doAround(ProceedingJoinPoint pJoinPoint) throws Throwable {
        System.out.println("环绕通知");
        Object result=null;
        // 这里如果pJoinPoint.proceed()不执行，后面拦截到的方法都不会执行，非常适用于权限管理
        //方法拦截链循环遍历,源码通过proceed方法进行递归调用,这里如果不写,
        // 递归调用终止,则后面的方法拦截器不会被遍历到,也不会执行最后
        //被代理的类的方法
        result = pJoinPoint.proceed();
        System.out.println("退出");
        return result;
    }
}
