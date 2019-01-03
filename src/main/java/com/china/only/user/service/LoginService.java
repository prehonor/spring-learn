package com.china.only.user.service;

import java.util.Map;

public interface LoginService {
    public Map<String,Object> login(Map<String,Object> params) throws Exception;
    public Map<String,Object> signUp(Map<String,Object> params) throws Exception;
    public Map<String,Object> sendArticle(Map<String,Object> params) throws Exception;
}
