package com.china.only.configuration;

import com.china.only.configuration.movie.TicketSaleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class TestConfiguration {
    public TestConfiguration(){
        System.out.println("TestConfiguration:构造方法被调用!!!");
    }

    @Bean(name="ticketSaleService")
    public TicketSaleService newTicketSaleService(){
        return new TicketSaleService("张三丰");
    }
}
