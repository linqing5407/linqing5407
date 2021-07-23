package com.example.demo.designpattern.factory.inter;

import lombok.Data;

public abstract class IAbstractOperatorImpl implements IOperator {

    protected Double numberA;

    protected Double numberB;

    protected void init(Double numberA ,Double numberB){
        this.numberA=numberA;
        this.numberB=numberB;
    }

    @Override
    public Double getNumberA() {
        return numberA;
    }

    public void setNumberA(Double numberA) {
        this.numberA = numberA;
    }

    @Override
    public Double getNumberB() {
        return numberB;
    }

    public void setNumberB(Double numberB) {
        this.numberB = numberB;
    }

    @Override
    public Double getResult() throws Exception {
        System.out.println("切面特殊处理");
        Double result = getPlay();
        return result;
    }

}
