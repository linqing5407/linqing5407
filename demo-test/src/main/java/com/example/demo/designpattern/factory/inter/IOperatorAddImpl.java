package com.example.demo.designpattern.factory.inter;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service("operatorAdd")
public class IOperatorAddImpl extends IAbstractOperatorImpl{

    public IOperatorAddImpl(){

    }
    public IOperatorAddImpl(Double numA, Double numB){
        this.init(numA,numB);
    }

    @Override
    public Double getPlay() throws Exception {

        Double result = numberA +numberB;
        return result;
    }

}
