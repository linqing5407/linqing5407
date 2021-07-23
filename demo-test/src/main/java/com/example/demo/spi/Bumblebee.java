package com.example.demo.spi;


import com.alibaba.dubbo.config.annotation.Service;

@Service(interfaceName="bumblebee")
public class Bumblebee implements Robot {

    @Override
    public void sayHello() {
        System.out.println("Hello, I am Bumblebee.");
    }
}
