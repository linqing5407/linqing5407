package com.example.demo.designpattern.factory.inter;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service("operatorSub")
@NoArgsConstructor
public class IOperatorSubImpl extends IAbstractOperatorImpl{
    public  IOperatorSubImpl(Double numA, Double numB){
        this.init(numA,numB);
    }

    @Override
    public Double getPlay() throws Exception {
        Double result = numberA -numberB;
        return result;
    }
}
