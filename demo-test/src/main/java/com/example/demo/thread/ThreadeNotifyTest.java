package com.example.demo.thread;

public class ThreadeNotifyTest {

    public static void main(String[] args) {

        final PrintAb  printAb =new PrintAb();

        new Thread("______thre1name"){
            @Override
            public void run() {
                printAb.printA();

            }
        }.start();

        new Thread("______thre2name"){
            @Override
            public void run() {
                printAb.printB();
            }
        }.start();

        new Thread("______thre3name"){
            @Override
            public void run() {
                printAb.printC();

            }
        }.start();

        new Thread("______thre4name"){
            @Override
            public void run() {

                printAb.printD();
            }
        }.start();
        new Thread("______thre5name"){
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("当前唤醒线程是");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                printAb.printE();
            }
        }.start();
    }



    static class PrintAb{

        private boolean flag =true;

          synchronized void printA(){
              try {
                  System.out.println("1"+Thread.currentThread().getName());
                  wait();
                  System.out.println("2"+Thread.currentThread().getName());
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }

          synchronized void printB(){
              try {
                  System.out.println("1"+Thread.currentThread().getName());
                  wait();
                  System.out.println("2"+Thread.currentThread().getName());
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
        synchronized void printC(){
            try {
                System.out.println("1"+Thread.currentThread().getName());
                wait();
                System.out.println("2"+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized void printD(){
            try {
                System.out.println("1"+Thread.currentThread().getName());
                wait();
                System.out.println("2"+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        synchronized void printE(){
            try {
               notify();
               notify();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}
