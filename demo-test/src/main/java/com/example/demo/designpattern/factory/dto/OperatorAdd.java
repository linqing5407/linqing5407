package com.example.demo.designpattern.factory.dto;

import lombok.Data;

@Data
public class OperatorAdd extends Operator {

    @Override
    public Double getResult(Double numberA,Double numberB){

        Double result = numberA +numberB;
        return result;
    }

}
