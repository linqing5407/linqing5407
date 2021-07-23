package com.example.demo.singleton;

import com.example.demo.designpattern.decorator.Person;
import com.example.demo.spi.Robot;

public enum  SingleDemoEnum {

    INSTANCE;
    private Robot robot=null;

//    private SingleDemoEnum(){
//        robot =new Robot();
//    }

    public SingleDemoEnum getInstance(){
        return INSTANCE;
    }

    public void sayHello(){
        System.out.println("sayHello");
    }

    public  Robot getRobot(){
        return robot;
    }
}
