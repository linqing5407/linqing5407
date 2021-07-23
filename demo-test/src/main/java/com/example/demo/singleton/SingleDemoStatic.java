package com.example.demo.singleton;

//静态内部类实现模式（线程安全，调用效率高，可以延时加载）
public class SingleDemoStatic {

    //JVM在类的初始化阶段（即在Class被加载后，且被线程使用之前），会执行类的初始化。
    // 在执行类的初始化期间，JVM会去获取一个锁。
    // 这个锁可以同步多个线程对同一个类的初始化。
    private static class SingleDemoStaticClass{
        private final static SingleDemoStatic instance=new SingleDemoStatic();

    }

    private SingleDemoStatic(){}


    public static SingleDemoStatic getInstance(){

      return  SingleDemoStaticClass.instance;

    }

}
