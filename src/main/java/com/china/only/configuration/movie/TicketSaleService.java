package com.china.only.configuration.movie;

public class TicketSaleService {
    private String name;

    public TicketSaleService(String name){
        this.name = name;
    }

    public void saler(){
        System.out.println("售票员的名字:"+name);
    }
}
