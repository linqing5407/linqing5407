package com.example.demo.designpattern.factory.dto;

import lombok.Data;

@Data
public class OperatorDiv extends Operator   {

    @Override
    public Double getResult(Double numberA,Double numberB)throws Exception{

        if (numberB == 0) {
            throw new Exception("除数不能为0");
        }
        Double result = numberA/numberB;
        return result;
    }

}
