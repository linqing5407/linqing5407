package com.example.demo.designpattern.strategy.dto;

/**
 *
 */
public class MarkMoneyCountPartC extends MarkMoneyCount {

    private long countAll=600L;
    private long reduce=60L;

    public MarkMoneyCountPartC(Long money){
        this.money =money;
        this.countAll =countAll;
    }

    @Override
    public Long getMoneyByAlgorithm(){
        if(money>countAll){
           money = money-reduce;
        }
        return money;

    }


}
