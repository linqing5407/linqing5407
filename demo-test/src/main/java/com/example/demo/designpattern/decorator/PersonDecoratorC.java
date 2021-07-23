package com.example.demo.designpattern.decorator;

public  class PersonDecoratorC extends PersonDecorator {

    @Override
    public void show() {

        super.show();
       System.out.println("穿内裤C");
    }
}
