package com.example.demo.designpattern.factory.inter;

import org.springframework.stereotype.Service;

@Service("operatorMul")
public class IOperatorMulImpl extends IAbstractOperatorImpl{
    public IOperatorMulImpl(){

    };

    public  IOperatorMulImpl(Double numA, Double numB){
        this.init(numA,numB);
    }

    @Override
    public Double getPlay() throws Exception {
        Double result = numberA * numberB;
        return result;
    }
}
