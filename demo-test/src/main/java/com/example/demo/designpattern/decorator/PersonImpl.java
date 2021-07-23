package com.example.demo.designpattern.decorator;

public class PersonImpl implements Person {

    private String name;

    public PersonImpl(String name){
        this.name =name;
    }


    @Override
    public void show() {
        System.out.println("装饰的："+name);
    }
}
