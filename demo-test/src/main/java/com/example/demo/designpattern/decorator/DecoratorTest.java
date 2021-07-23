package com.example.demo.designpattern.decorator;

public class DecoratorTest {

    public static void main(String[] args) {

        // 按先后顺序来执行 先执行 c  再执行d1  再执行d2
//        ConcreteComponent c = new ConcreteComponent();
//        ConcreteComponentA d1 = new ConcreteComponentA();
//        ConcreteComponentB d2 = new ConcreteComponentB();
//        System.out.println("c:");
//        c.operation();
//        d1.setComponent(c);
//        System.out.println("d1:");
//        d1.operation();
//        d2.setComponent(d1);
//        System.out.println("d2:");
//        d2.operation();


        PersonDecorator A =new PersonDecoratorA();
        PersonDecorator B =new PersonDecoratorB();
        PersonDecorator C =new PersonDecoratorC();
        PersonDecorator D =new PersonDecoratorD();
        PersonImpl p=new PersonImpl("小明");
        C.setPersonShow(p);
        A.setPersonShow(C);
        B.setPersonShow(A);
        D.setPersonShow(B);
        D.show();
}


}
