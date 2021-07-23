package com.example;

public class StringTest {

    public static void main(String[] args) {
        String s1 = "javaEE";
        String s2 = "hadoop";
        String s3 = "javaEEhadoop";
        // 引号中的为字面量，这里是字面量的拼接
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;
        final String s8 = "hadoop";
        String s9 = "javaEE" + s8;
        String mm ="99";
        String mn ="99";
        System.out.println(System.identityHashCode(mm));
        System.out.println(System.identityHashCode(mn));
        System.out.println(mm == mn);
        System.out.println(System.identityHashCode(s3));
        System.out.println(System.identityHashCode(s4));
        System.out.println(s3 == s4);//true
        System.out.println(System.identityHashCode(s3));
        System.out.println(System.identityHashCode(s5));
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s5 == s6);//false
        System.out.println(s5 == s7);//false
        System.out.println(s6 == s7);//false
        System.out.println(s3 == s9);//true

        String s10 = s5.intern();//返回值得到的s8使用的常量值中已经存在的”javaEEhadoop“（s5.intern返回的时常量池中对应的内存地址）
        System.out.println(s3 == s10);//true
    }

}
