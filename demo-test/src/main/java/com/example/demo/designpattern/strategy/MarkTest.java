package com.example.demo.designpattern.strategy;


import java.util.Scanner;

public class MarkTest {


    public static void main(String[] args) throws Exception {

        //策略模式
        MarkStrategy ms  = null;
        ms  = new MarkStrategy(800L,"打折消费");
        ms.getResult();
        System.out.println( ms.getResult());
        ms  = new MarkStrategy(800L,"满减消费");
        ms.getResult();
        System.out.println( ms.getResult());
        ms  = new MarkStrategy(800L,"普通消费");
        ms.getResult();
        System.out.println( ms.getResult());

    }


}
