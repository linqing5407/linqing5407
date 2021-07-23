package com.example.demo.designpattern.factory;


import com.example.demo.designpattern.factory.inter.*;

public  class IOperatorFactory {


    public static IOperator createOperator(Double numberA, Double numberB, String simple){

        switch (simple){
            case "+":{
                return  new IOperatorAddImpl(numberA,numberB);

            }
            case "-":{
                return  new IOperatorSubImpl(numberA,numberB);

            }
            case "*":{
                return  new IOperatorMulImpl(numberA,numberB);

            }
            case "/":{
                return  new IOperatorDivImpl(numberA,numberB);
            }

        }
        return null;
    }


}
