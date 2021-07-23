package com.example.demo.annoation;


import lombok.Data;

@Data
public class MyBean {

    private String data;


    public MyBean(){
        System.out.println("MyBean Initializing");
    }

    public void MyBeanInit(){
        System.out.println("初始化之前");
    }
    public void MyBeanDestory(){
        System.out.println("消毁对象后");
    }

}
