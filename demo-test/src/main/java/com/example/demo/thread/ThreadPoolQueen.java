package com.example.demo.thread;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import java.util.concurrent.*;

public class ThreadPoolQueen {


        public static void main(String[] args) {
            BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(100);
            BlockingQueue<Runnable> arrayQueue = new ArrayBlockingQueue<Runnable>(100,true);
//            BlockingQueue<Runnable> syncQueue = new SynchronousQueue<>();
//            BlockingQueue<Runnable> delayQueue = new DelayQueue<Runnable>();
            ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 6, 1, TimeUnit.DAYS, queue);
            for (int i = 0; i < 10; i++) {
                executor.execute(new Thread(new ThreadPoolTest(), "TestThread".concat("" + i)));
                int threadSize = queue.size();
                System.out.println("线程队列大小为-->" + threadSize);
            }
            executor.shutdown();
        }
    }


