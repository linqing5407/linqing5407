package com.example.demo.designpattern.strategy.dto;

/**
 * 原价
 */
public class MarkMoneyCountPartA extends MarkMoneyCount {


    public MarkMoneyCountPartA(Long money){
        this.money =money;
    }

    @Override
    public Long getMoneyByAlgorithm(){

        return money;

    }


}
