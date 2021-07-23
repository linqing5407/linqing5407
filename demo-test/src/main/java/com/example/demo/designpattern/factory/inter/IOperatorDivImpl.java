package com.example.demo.designpattern.factory.inter;

import org.springframework.stereotype.Service;

@Service("operatorDiv")
public class IOperatorDivImpl extends IAbstractOperatorImpl{

    public IOperatorDivImpl(){

    }
    public IOperatorDivImpl(Double numA,Double numB){
        this.init(numA,numB);
    }

    @Override
    public Double getPlay() throws Exception {
        if (numberB == 0) {
            throw new Exception("除数不能为0");
        }
        Double result = numberA /numberB;
        return result;
    }
}
