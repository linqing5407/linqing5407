package com.example.demo.designpattern.strategy.dto;

/**
 * 打折
 */
public class MarkMoneyCountPartB extends MarkMoneyCount {

    private long radio=8;

    public MarkMoneyCountPartB(Long money)
    {
        this.money =money;
    }

    @Override
    public Long getMoneyByAlgorithm(){
       long result = money*radio;
      return result;

    }


}
