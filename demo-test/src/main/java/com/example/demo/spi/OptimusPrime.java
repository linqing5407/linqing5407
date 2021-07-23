package com.example.demo.spi;


import com.alibaba.dubbo.config.annotation.Service;

@Service(interfaceName="optimusPrime")
public class OptimusPrime implements Robot {

    @Override
    public void sayHello() {
        System.out.println("Hello, I am Optimus Prime.");
    }
}

