package com.github.shehanperera.example;

public class Method{

    Method(){

        System.out.println("This is constructor ");
    }
    public static void method1(){

        try {
            Thread.sleep(500);
            System.out.println("This is Method 1");
        } catch (InterruptedException e) {
            //Ignore
        }
    }
    public static void method2(){

        try {
            Thread.sleep(1000);
            System.out.println("This is Method 2");
        } catch (InterruptedException e) {
            //Ignore
        }
    }
}