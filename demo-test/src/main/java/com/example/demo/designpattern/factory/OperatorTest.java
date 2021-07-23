package com.example.demo.designpattern.factory;



import com.example.demo.designpattern.factory.dto.Operator;
import com.example.demo.designpattern.factory.inter.IOperator;

import java.util.Scanner;

public class OperatorTest {


    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个数字：");
        Double numberA =sc.nextDouble();
        System.out.print("请输入一个符号：");
        String simple =sc.next();
        System.out.print("请输入一个数字：");
        Double numberB =sc.nextDouble();
        //类重写 工厂模式
        Operator op =OperatorFactory.createOperator(simple);
        Double result = op.getResult(numberA,numberB);
        System.out.println(numberA+" "+simple+" "+numberB+" = "+result);

        //接口实现 工厂模式
        IOperator io =IOperatorFactory.createOperator(numberA,numberB,simple);
        System.out.println(io.getNumberA()+" "+simple+" "+ io.getNumberB()+" = "+io.getResult());
    }


}
