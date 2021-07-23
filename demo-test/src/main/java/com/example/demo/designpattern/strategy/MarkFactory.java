
package com.example.demo.designpattern.strategy;


import com.example.demo.designpattern.strategy.dto.MarkMoneyCount;
import com.example.demo.designpattern.strategy.dto.MarkMoneyCountPartA;
import com.example.demo.designpattern.strategy.dto.MarkMoneyCountPartB;
import com.example.demo.designpattern.strategy.dto.MarkMoneyCountPartC;

public  class MarkFactory {


    public static MarkMoneyCount createOperator(Long money, String simple){

        switch (simple){
            case "普通消费":{
                return  new MarkMoneyCountPartA(money);

            }
            case "打折消费":{
                return  new MarkMoneyCountPartB(money);

            }
            case "满减消费":{
                return  new MarkMoneyCountPartC(money);

            }

        }
        return null;
    }


}
