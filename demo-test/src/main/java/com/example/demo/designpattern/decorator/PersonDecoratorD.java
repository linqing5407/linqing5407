package com.example.demo.designpattern.decorator;

public  class PersonDecoratorD extends PersonDecorator {

    @Override
    public void show() {
        super.show();
       System.out.println("穿皮鞋D");
    }
}
