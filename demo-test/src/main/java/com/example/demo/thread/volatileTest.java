package com.example.demo.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class volatileTest {

   // public static volatile int num = 0;
    //使用原子操作类
    public static AtomicInteger num = new AtomicInteger(0);

    //使用CountDownLatch来等待计算线程执行完
    static CountDownLatch countDownLatch = new CountDownLatch(30);
    public static void main(String []args) throws InterruptedException {
        //开启30个线程进行累加操作
        for(int i=0;i<30;i++){
            new Thread(){
                @Override
                public void run(){
                    for(int j=0;j<10000;j++){
                        num.incrementAndGet();//原子性的num++,通过循环CAS方式
                        //num = num+1;
                    }
                    countDownLatch.countDown();
                }
            }.start();
        }
        //等待计算线程执行完
        countDownLatch.await();
        System.out.println(num);
    }


}
