package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * 1、主要思路类似于lru算法 通过一个双向链表 + hashmap 来实现 过期淘汰策略 （超过1024 移除尾部的节点 同时触发回调函数 lruCallback）
 * 2、构建定时任务超过一个小时，移除节点 同时执行回调方法（得注意我们访问的时候需延长 定时任务的时间 timeoutCallback）
 * 3、可以考虑在redis 设置过期key 触发回调 ,记得移除节点的时候删除对应的redis数据， 一小时内被访问的节点重新设置过期时间为一小时
 * @author:   林青
 * @Createdate:  2021年7月22日
 */
public class LruTestClass {
    /**
     * 延迟时间 秒
     */
    private static Integer MAX_TIME_OUT = 3600;
    /**
     * 默认1024 大小
     */
    private static Integer MAX_SIZE = 1024;
    /**
     * 当前map的大小
     */
    private  int currentSize;
    /**
     * 链表的头结点
     */
    private DoubleLinkNode headNode;
    /**
     * 链表的尾结点l
     */
    private DoubleLinkNode lastNode;;
    /**
     * 当前构建的map 缓存大小
     */
    private Map<Integer, DoubleLinkNode> lruLinkMap = new HashMap<Integer,DoubleLinkNode>(MAX_SIZE);
    /**
     * 创建定时任务的线程池
     */
    private ScheduledExecutorService mScheduledExecutorService = Executors.newScheduledThreadPool(MAX_SIZE);
    /**
     * 一个小时没有被访问 执行回调方法移除key
     */
    private Map<Integer, Runnable> timeOutMap = new HashMap<Integer, Runnable>(MAX_SIZE);

    /**
     *
     * 先构建一个双向链表
     * @author:      林青
     * @Createdate:  2021年7月22日
     */
    class DoubleLinkNode {

        int key;
        int value;
        DoubleLinkNode preNode;
        DoubleLinkNode nextNode;

        // 构造方法
        public DoubleLinkNode() {};

        public DoubleLinkNode(int key_v, int value_v) {
            key = key_v;
            value = value_v;
        }
    }
    /**
     * 双向链表 加入到头结点
     * 因为有创建虚拟节点 所以从第二个节点开始
     * @param node
     */
    private void addHead(DoubleLinkNode node) {
        node.preNode = headNode;
        node.nextNode = headNode.nextNode;
        headNode.nextNode.preNode = node;
        headNode.nextNode = node;
    }

    /**
     * 双向链表 移除单前结点
     * @param node
     */
    private void removeNode(DoubleLinkNode node) {
        node.preNode.nextNode = node.nextNode;
        node.nextNode.preNode = node.preNode;
    }

    /**
     * 移除单前访问的节点 （包括查询和插入的时候）
     * 加入到头结点
     * @param node 当前节点
     */
    private void moveToHead(DoubleLinkNode node) {
        removeNode(node);
        addHead(node);
    }

    /**
     *  超过数量1024 移除链表尾部的节点(尾部的节点就是最久没访问的节点)
     * @return
     */
    private DoubleLinkNode removeTail() {
        // 存在虚拟节点
        DoubleLinkNode res = lastNode.preNode;
        removeNode(res);
        return res;
    }

    /**
     *  初始化map
     * @param
     */
    public LruTestClass() {
        this.currentSize = 0;
        // 创建虚拟的头部节点 和 虚拟的尾部节点
        headNode = new DoubleLinkNode();
        lastNode = new DoubleLinkNode();
        lastNode.preNode = headNode;
        headNode.nextNode = lastNode;
    }

    /**
     *  get方法获取数据是 需要更新 链表
     * @param key 传入的hash key
     * @return 返回值
     */
    public int get(int key) {
        DoubleLinkNode node = lruLinkMap.get(key);
        // 节点为空返回 -1
        if (node == null) {
            return -1;
        }
        // 访问到该节点 需将其移动到头部 同时延长定时任务的时间
        moveToHead(node);
        // 延迟线程时间
        if(timeOutMap.get(key) != null){
            mScheduledExecutorService.schedule(timeOutMap.get(key), MAX_TIME_OUT, TimeUnit.SECONDS);
        }
        return node.value;
    }

    /**
     * 新增 节点的时候也许将其移动到头部
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        // 判断该值是否存在
        DoubleLinkNode node = lruLinkMap.get(key);
        if (node == null) {
            // 创建新节点放入
            DoubleLinkNode newNode = new DoubleLinkNode(key, value);
            // 新增的节点也要加入到头部
            addHead(newNode);
            // 放进map
            lruLinkMap.put(key, newNode);
            // 元素数量加一
            currentSize++;
            if (currentSize > MAX_SIZE) {
                // 如果超出数量， 移除链表的最后一个节点
                DoubleLinkNode tail = removeTail();
                // 对应的移除map中的元素
                lruLinkMap.remove(tail.key);
                // 移除延迟线程
                timeOutMap.remove(tail.key);
                currentSize--;
                // 超过1024 执行回调函数
                lruCallback(tail.key, tail.value);
            }
            // 成功创建节点 调用延时方法开始倒计时
            createTimeOutTask(key, value);
        } else {
            // 如果节点存在， 先定位到节点 更改节点的值 移动到头节点
            node.value = value;
            moveToHead(node);
        }
    }


    /**
     *  创建一笑的倒计时
     * @param key
     * @param value
     */
    public void createTimeOutTask(int key, int value) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                timeoutCallback(key, value);
            }
        };
        // 延时任务 具备超时功能， 当键值对1小时内没有被访问， 就被淘汰掉, 当淘汰时， 需要调用一个callback   timeoutCallback(K key, V value);
        mScheduledExecutorService.schedule(runnable, MAX_TIME_OUT, TimeUnit.SECONDS);
        timeOutMap.put(key,runnable);
    }



    /**
     * 超过一个小时后 没有访问 直接执行回调函数
     * @param key
     * @param value
     */
    public void timeoutCallback(int key ,int value){
        // 获取对应节点
        DoubleLinkNode node = lruLinkMap.get(key);
        removeNode(node);
        // 对应的移除map中的元素
        lruLinkMap.remove(key);
        // 执行回调方法
        System.out.println("一个小时没有被访问执行回调函数 key :" + key + "value" + value);
    }

    /**
     * 超过1024 个执行回调 函数
     * @param key
     * @param value
     */
    public void lruCallback(int key ,int value){
        System.out.println(" 超过1024个 执行回调函数触发动作 key :" + key + "value" + value);
    }



    public static void main(String[] args) {
        // 测试类验证数量超过 1024 触发回调函数
        LruTestClass test = new LruTestClass();
        for(int i =0; i < 1050; i++){
            test.put(i, i);
        }

    }
}
