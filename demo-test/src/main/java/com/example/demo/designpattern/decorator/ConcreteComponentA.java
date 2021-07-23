package com.example.demo.designpattern.decorator;

import org.springframework.stereotype.Service;
@Service("concreteComponentA")
public class ConcreteComponentA extends Decorator {


    private String addedState;

    @Override
    public void operation() {
        super.operation();
        addedState = "new state";
        System.out.println("具体对象的操作A类"+addedState);
    }
}
