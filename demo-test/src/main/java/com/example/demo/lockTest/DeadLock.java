package com.example.demo.lockTest;

public class DeadLock {

    private static  String A ="A";
    private static  String B ="B";

    public  void main(String[] args) {
        int i=0;
        i++;
    }

    private void dead(){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B){
                        System.out.println("1");
                    }
                }
            }
        });

        Thread thread2 =new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B){
                    synchronized (A){
                        System.out.println("2");
                    }
                }
            }
        });
        thread1.start();
        thread2.start();

    }

}
