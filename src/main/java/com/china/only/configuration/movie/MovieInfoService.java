package com.china.only.configuration.movie;

import org.springframework.stereotype.Component;

@Component
public class MovieInfoService {
    public void getMovieInfo(){
        System.out.println("该电影含有大量少儿不宜的镜头,13岁以下儿童必须组队观看!");
    }
}
