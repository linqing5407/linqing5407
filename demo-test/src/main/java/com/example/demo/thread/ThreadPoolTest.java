package com.example.demo.thread;

public class ThreadPoolTest implements Runnable  {

        @Override
        public void run() {
            synchronized (this) {
                try {
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

}
