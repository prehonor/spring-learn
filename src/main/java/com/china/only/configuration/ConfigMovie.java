package com.china.only.configuration;

import org.springframework.stereotype.Component;

@Component("configMovie")
public class ConfigMovie {
    public void uploadMovie(){
        System.out.println("上传特殊影片中!!!");
    }
}
