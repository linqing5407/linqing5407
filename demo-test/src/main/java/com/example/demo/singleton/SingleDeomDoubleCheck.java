package com.example.demo.singleton;

/**
 * 懒汉式
 *
 * 线程安全，调用效率不高，但是能延时加载：
 */
public class SingleDeomDoubleCheck {

    //类初始化时，不初始化这个对象(延时加载，真正用的时候再创建)   volatile 防止重排序的出现 instance =new SingleDeomDoubleCheck();
    private volatile  static SingleDeomDoubleCheck instance;

    //构造器私有化
    private SingleDeomDoubleCheck(){}

    //方法同步，调用效率低
    public  static SingleDeomDoubleCheck getInstance(){

        if(instance==null){

            synchronized (SingleDeomDoubleCheck.class){

                if(instance==null){
                    // 二次校验 线程A执行完毕对象已创建
                    // 正巧线程B过了第一个if 进来后二次校验确保不会重复

                    instance =new SingleDeomDoubleCheck();

                    //2  3 步骤可能重排序 线程A进来3  线程B到第一个IF的时候 内存指向了对象未初始化
                    //volatile 新增防止重排序
                    //memory = allocate();   //1：分配对象的内存空间
                    //ctorInstance(memory);  //2：初始化对象
                    //instance = memory;     //3：设置instance指向刚分配的内存地址
                }
            }

        }
        return  instance;
    }


}
