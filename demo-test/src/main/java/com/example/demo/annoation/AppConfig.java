package com.example.demo.annoation;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class AppConfig {

    @Bean(name="myBeanTest",initMethod="MyBeanInit",destroyMethod="MyBeanDestory")
    public MyBean myBean() {
        return new MyBean();
    }


}
