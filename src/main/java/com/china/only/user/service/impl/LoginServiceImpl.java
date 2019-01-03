package com.china.only.user.service.impl;

import com.china.only.user.service.LoginService;

import java.util.HashMap;
import java.util.Map;

public class LoginServiceImpl implements LoginService {


    @Override
    public Map<String, Object> login(Map<String, Object> params) throws Exception {
        System.out.println("login ... complete!");
        try{
            return new HashMap<>();
        }finally {
            throw new Exception("手动抛出的异常!");
        }
    }

    @Override
    public Map<String, Object> signUp(Map<String, Object> params) throws Exception {
        System.out.println("signUp ... complete!");
        return new HashMap<>();
    }

    @Override
    public Map<String, Object> sendArticle(Map<String, Object> params) throws Exception {
        System.out.println("sendArticle ... complete!");
        return new HashMap<>();
    }
}
