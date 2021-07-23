package com.example.demo.codes;

import lombok.SneakyThrows;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CodingTest  {

//    public static void main(String[] args) {
//
//        File file = new File("\\data\\net");
//        System.out.println(file.toString());
//        File [] files = file.listFiles();
//        System.out.println(files);
//        System.out.println(files.length);
////        float a = 1.0f - 0.9f;
////        float b = 0.9f - 0.8f;
////
////        if (a == b) {
////            // 预期进入此代码快，执行其它业务逻辑
////            // 但事实上 a==b 的结果为false
////            System.out.println("true");
////        }
////
////        Float x = Float.valueOf(a);
////        Float y = Float.valueOf(b);
////        if (x.equals(y)) {
////            // 预期进入此代码快，执行其它业务逻辑
////            // 但事实上 equals 的结果为false
////            System.out.println("false");
////        }
//
//
//    }


    public static void main(String[] args) {

         final AtomicInteger mm = new AtomicInteger(0);

        new Thread(){
            @SneakyThrows
            @Override
            public void run() {
                for(;;){
                    if(mm.intValue()==0){
                        System.out.println("A");
                        mm.incrementAndGet();
                        this.wait();
                    }

                }

            }
        }.start();

        new Thread(){
            @SneakyThrows
            @Override
            public void run() {
               for(;;){
                   if(mm.intValue()==1){
                       System.out.println("B");
                       mm.decrementAndGet();
                       Thread.sleep(1000);
                   }
               }
            }
        }.start();
    }



}
