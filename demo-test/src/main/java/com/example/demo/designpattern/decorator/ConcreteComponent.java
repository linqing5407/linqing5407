package com.example.demo.designpattern.decorator;

import org.springframework.stereotype.Service;

@Service("concreteComponent")
public class ConcreteComponent implements Component {

    @Override
    public void operation() {
        System.out.println("具体对象的操作");
    }
}
