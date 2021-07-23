package com.example.demo.designpattern.proxy;

public class Proxy implements Givegife {

    private Pursuit pursuit;
    private String name;

    public Proxy(Pursuit pursuit,String name) {
        this.pursuit = pursuit;
        this.name =name;
    }

    @Override
    public void giveFlowers() {
        System.out.println("通过代理:"+name);
        pursuit.giveFlowers();
    }

    @Override
    public void giveDolls() {
        System.out.println("通过代理:"+name);
        pursuit.giveDolls();
    }

    @Override
    public void giveChocolate() {
        System.out.println("通过代理:"+name);
        pursuit.giveChocolate();
    }
}
