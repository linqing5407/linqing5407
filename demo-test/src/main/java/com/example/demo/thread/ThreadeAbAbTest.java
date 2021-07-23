package com.example.demo.thread;


public class ThreadeAbAbTest {

    public static void main(String[] args) {

        final PrintAb  printAb =new PrintAb();

//        Runnable runnable =new Runnable() {
//            @Override
//            public void run() {
//                for(int i=0;i<10;i++){
//                    printAb.printA(i);
//                }
//            }
//        };
//        Thread thread4 = new Thread(runnable);
//        thread4.start();


        new Thread(){
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    printAb.printA(i);
                }

            }
        }.start();




        new Thread(){
            @Override
            public void run() {
                for(int i=0;i<10;i++) {
                    printAb.printB(i);
                }
            }
        }.start();
    }



    static class PrintAb{

        private volatile boolean flag =false;


          synchronized void printA(int k){
              while(flag){
                  try {
                      this.wait();
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }
          flag =true;
          this.notify();
          System.out.println(k+"-----A"+Thread.currentThread().getName());
      }

        synchronized void printB(int k){
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            while(!flag){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(k+"-----B"+Thread.currentThread().getName());
            flag =false;
            this.notify();
        }

    }

}
