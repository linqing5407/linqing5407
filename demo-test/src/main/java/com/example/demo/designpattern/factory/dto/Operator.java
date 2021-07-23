package com.example.demo.designpattern.factory.dto;


import lombok.Data;

@Data
public class Operator {


    private Double numberA;

    private Double numberB;


    public Double getResult(Double numberA,Double numberB)throws Exception{

        Double result = numberA +numberB;
        return result;
    }

}
