package com.example.demo.designpattern.strategy;


import com.example.demo.designpattern.strategy.dto.MarkMoneyCount;

public  class MarkStrategy {

    private MarkMoneyCount markMoneyCount;

    public MarkStrategy(Long money,String simple){
        this.markMoneyCount =MarkFactory.createOperator( money,simple);
    }

   public long getResult(){
      return markMoneyCount.getMoneyByAlgorithm();
   }
}
