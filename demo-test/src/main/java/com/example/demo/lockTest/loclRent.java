package com.example.demo.lockTest;

import java.util.HashMap;

public class loclRent{
    boolean isLocked = false;
    Thread  lockedBy = null;
    int lockedCount = 0;

    //可重入锁实现原理
    public synchronized void lock()
            throws InterruptedException{
        Thread thread = Thread.currentThread();
        while(isLocked && lockedBy != thread){
            wait();
        }
        isLocked = true;
        lockedCount++;
        lockedBy = thread;
    }
    public synchronized void unlock(){
        if(Thread.currentThread() == this.lockedBy){
            lockedCount--;
            if(lockedCount == 0){
                isLocked = false;
                notify();
            }
        }
    }

    public void test1(){
        int i=0;
        int a = i++;
    }

    public void test2(){
        int i=0;
        int a = ++i;
    }
    /**
     * 不可重入锁实现原理
     * @throws InterruptedException
     */
    public synchronized void lockCanNot() throws InterruptedException{
        while(isLocked){
            wait();
        }
        isLocked = true;
    }
    public synchronized void unlockCanNot(){
        HashMap map = new HashMap(16);
        map.put("","");
        isLocked = false;
        notify();
    }

}