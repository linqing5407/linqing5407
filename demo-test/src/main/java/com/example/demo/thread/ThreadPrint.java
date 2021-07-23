package com.example.demo.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author:   林青
 * @Createdate:  2021年7月22日
 */
public class ThreadPrint implements Runnable {

    @Override
    public void run() {
        CountDownLatch countDownLatch1 = new CountDownLatch(1);
        threadMessage("Thread Start");
        threadMessage("动作1");
        runTwoThread();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadMessage("动作4");
        ThreadPrint.class.notifyAll();
        threadMessage("1-Thread END");
    }

    private void runTwoThread(){
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for(int i=0;i<2 ;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int action = i+1;

            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                        threadMessage("Thread Start");
                        threadMessage("动作"  + action);
                        //wait();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        countDownLatch.countDown();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //ThreadTest.class.notify();
        threadMessage("2-3 Thread END");
    }

    public static void threadMessage(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.format("%s: %s%n", threadName, message);
    }

    public static void main(String args[]) throws InterruptedException {
        Thread t = new Thread(new ThreadPrint());
        t.start();
    }
}

