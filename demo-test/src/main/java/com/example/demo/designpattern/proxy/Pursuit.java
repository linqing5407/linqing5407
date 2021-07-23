package com.example.demo.designpattern.proxy;

public class Pursuit implements Givegife {

    private String name ;

    private String girlName;

    public Pursuit(ShcoolGirl shcoolGirl,String name){
        this.girlName =shcoolGirl.getName();
        this.name="追求者："+name;
    }

    @Override
    public void giveFlowers() {

        System.out.println(name+"  送鲜花给: "+girlName);
    }

    @Override
    public void giveDolls() {
        System.out.println(name+"  送娃娃给: "+girlName);
    }

    @Override
    public void giveChocolate() {
        System.out.println(name+"  送巧克力给: "+girlName);
    }
}
