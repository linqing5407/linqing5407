package com.example.demo.designpattern.factory;


import com.example.demo.designpattern.factory.dto.*;

public  class OperatorFactory {


    public static Operator createOperator(String simple){

        switch (simple){
            case "+":{
                return  new OperatorAdd();

            }
            case "-":{
                return  new OperatorSub();

            }
            case "*":{
                return  new OperatorMul();

            }
            case "/":{
                return  new OperatorDiv();
            }

        }
        return null;
    }


}
