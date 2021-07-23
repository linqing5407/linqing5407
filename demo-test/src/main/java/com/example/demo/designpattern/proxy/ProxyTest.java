package com.example.demo.designpattern.proxy;

public class ProxyTest {


    public static void main(String[] args) {

        //贾明 通过代理 小菜  送礼物给 娇娇
        ShcoolGirl shcoolGirl = new ShcoolGirl("娇娇");
        Pursuit pursuit =new Pursuit(shcoolGirl,"贾明");
        Proxy  proxy =new Proxy(pursuit,"小菜");
        proxy.giveChocolate();
        proxy.giveDolls();
        proxy.giveFlowers();
    }



}
