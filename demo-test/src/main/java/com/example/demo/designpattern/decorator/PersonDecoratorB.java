package com.example.demo.designpattern.decorator;

public  class PersonDecoratorB extends PersonDecorator {

    @Override
    public void show() {

        super.show();
       System.out.println("穿裤子B");
    }
}
