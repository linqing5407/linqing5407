package com.example.demo.singleton;

import org.junit.Test;

public class TestDemoSingle {

    @Test
    public void EnumSinglRun(){

        SingleDemoEnum.INSTANCE.sayHello();
        SingleDemoEnum.INSTANCE.sayHello();
        SingleDemoEnum.INSTANCE.sayHello();

    }
}
