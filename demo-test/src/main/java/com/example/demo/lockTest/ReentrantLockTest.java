package com.example.demo.lockTest;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
@Slf4j
public class ReentrantLockTest {

    private static   ReentrantLock lock =new ReentrantLock(true);

    public static void main(String[] args) {
        new Thread(()->test(),"线程A").start();
        new Thread(()->test(),"线程B").start();
        new Thread(()->test(),"线程C").start();
        new Thread(()->test(),"线程D").start();
        new Thread(()->test(),"线程E").start();

    }

    public static void test(){

        for(int i=0;i<3;i++){

            try {
               lock.lock();
               log.info(Thread.currentThread().getName()+"获取了锁"+i);
               TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }

    }

}
