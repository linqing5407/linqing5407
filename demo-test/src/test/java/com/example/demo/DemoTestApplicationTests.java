package com.example.demo;

import com.example.demo.annoation.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class DemoTestApplicationTests {

    @Test
    void contextLoads() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Object ob =context.getBean("myBeanTest");
        ((AnnotationConfigApplicationContext) context).close();
    }

}
