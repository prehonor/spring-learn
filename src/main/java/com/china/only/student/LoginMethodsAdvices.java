package com.china.only.student;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterAdvice;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;
import java.lang.reflect.Method;

public class LoginMethodsAdvices implements MethodBeforeAdvice , AfterReturningAdvice, ThrowsAdvice, MethodInterceptor {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("before ...");
    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("afterReturning ..." + returnValue);
    }
    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
        System.out.println("afterThrowing "+ ex.getMessage());
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("环绕通知执行前.....");
        Object result = invocation.proceed();
        System.out.println("环绕通知执行后.....返回值" + result);
        result = 99;
        return result;
    }
}
