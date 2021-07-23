 package com.example.demo.designpattern.decorator;;

import org.springframework.stereotype.Service;

@Service("concreteComponentB")
public class ConcreteComponentB extends Decorator {


    private String addedState;

    @Override
    public void operation() {
        super.operation();
        System.out.println("具体对象的操作B类");
        behavior();
    }

    private void behavior(){
        System.out.println("B类可添加特殊操作");
    }
}
