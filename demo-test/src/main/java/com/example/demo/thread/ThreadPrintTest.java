package com.example.demo.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 笔试允许google/baidu 查资料, 但本着诚信原则, 建议在自己熟悉的ide 上编程后, 粘贴过来.


 //有3个线程， 线程1， 线程2和线程3， 每个线程严格执行自己的动作，
 //流程如下：
 //1. 线程1 执行动作1 后，创建线程2 和线程3， 创建线程2 和线程3后， block 线程1，直到 线程2 完成动作2和线程3 完成动作3  , 动作2 和动作3 都完成后, 才能激活线程1.
 //2. 线程2 启动后，执行动作2，执行完动作2后， block 线程2，直到线程1 完成动作4，然后线程2自己结束
 //3. 线程3 启动后，执行动作3，执行完动作3后， block 线程3，直到线程1 完成动作4，然后线程3自己结束。
 //4. 等动作2 和动作3 都完成后， 唤醒线程1， 唤醒线程1后， 执行动作4
 //5. 线程1 执行完动作4后， 等待线程2 和线程3 结束, 线程2和线程3 结束后,自己也退出。


 整个流程
 //动作1(线程1)  -- 动作2/动作3(线程2/线程3 是并行) -- 动作4 (线程1)

 动作1/动作2/动作3 -- 分别用print 答应一段语句即可
 */
public class ThreadPrintTest {

    private Object object = new Object();

    public void runFirst(){
        // 控制线程4的启动
        CountDownLatch countDownFirst = new CountDownLatch(2);
        // 控制最后退出
        CountDownLatch countDownLast = new CountDownLatch(2);

        Thread thread_A = new Thread(){
            @Override
            public void run() {

                    try {
                        System.out.println("时间"+System.currentTimeMillis()+"动作1"+Thread.currentThread());
                        // 创建线程二 线程三
                        createTwotread(countDownFirst,countDownLast);
                        // block 线程1
                        countDownFirst.await();
                        System.out.println("时间"+System.currentTimeMillis()+"动作4"+Thread.currentThread());
                        Thread.sleep(2);
                        synchronized (object) {
                            object.notifyAll();
                        }
                        countDownLast.await();
                        System.out.println("时间"+System.currentTimeMillis()+"自己退出"+Thread.currentThread());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

            }
        };
        thread_A.start();
    }



    // 创建线程二 和线程三
    public void createTwotread(CountDownLatch countDownFirst, CountDownLatch countDownLast) {
        // 通过CountDownLatch 控制两个线程并行
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Thread thread_B = new Thread() {
            @Override
            public void run() {

                    try {
                        Thread.sleep(5);
                        countDownLatch.await();
                        System.out.println("时间"+System.currentTimeMillis()+"动作2"+Thread.currentThread());
                        Thread.sleep(5);
                        countDownFirst.countDown();
                        synchronized (object) {
                            object.wait();
                        }
                        System.out.println("时间"+System.currentTimeMillis()+"线程二结束"+Thread.currentThread());
                        Thread.sleep(1);
                        countDownLast.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

            }
        };

        Thread thread_C = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5);
                    countDownLatch.await();
                    System.out.println("时间"+System.currentTimeMillis()+"动作3"+Thread.currentThread());
                    Thread.sleep(5);
                    countDownFirst.countDown();
                    synchronized (object) {
                        object.wait();
                    }
                    System.out.println("时间"+System.currentTimeMillis()+"线程三结束"+Thread.currentThread());
                    Thread.sleep(1);
                    countDownLast.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread_B.start();
        thread_C.start();
        // 并行二三 后阻塞
        countDownLatch.countDown();

    }

    public static void main(String args[]) throws InterruptedException {
        ThreadPrintTest tpt =new ThreadPrintTest();
        tpt.runFirst();
    }


}
