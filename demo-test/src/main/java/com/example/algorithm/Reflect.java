package com.example.algorithm;

import java.lang.reflect.Field;

public class Reflect {

    public static class Student {
        private int id;
        String name;
        protected boolean sex;
        public float score;
    }



        //获取反射机制三种方式
        public static void main(String[] args) throws ClassNotFoundException {
            //方式一(通过建立对象)
            Student stu = new Student();
            Class classobj1 = stu.getClass();
            System.out.println(classobj1.getName());
            //方式二（所在通过路径-相对路径）
            Class classobj2 = Class.forName("fanshe.Student");
            System.out.println(classobj2.getName());
            //方式三（通过类名）
            Class classobj3 = Student.class;
            System.out.println(classobj3.getName());

        }

}
