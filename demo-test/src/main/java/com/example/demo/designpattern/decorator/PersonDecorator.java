package com.example.demo.designpattern.decorator;

public abstract class PersonDecorator implements Person {

    private Person component;


    public  void setPersonShow(Person component){
        this.component =component;
    }

    @Override
    public void show() {
        if(component !=null){
            component.show();
        }
    }
}
