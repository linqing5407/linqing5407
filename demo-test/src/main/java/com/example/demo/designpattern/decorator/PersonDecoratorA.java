package com.example.demo.designpattern.decorator;

public  class PersonDecoratorA extends PersonDecorator {

    @Override
    public void show() {

        super.show();
       System.out.println("穿上衣A");
    }
}
