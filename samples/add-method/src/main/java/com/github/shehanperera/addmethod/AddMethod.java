package com.github.shehanperera.addmethod;

import net.bytebuddy.asm.Advice;

public class AddMethod {

    @Advice.OnMethodExit
    static void method3() throws Exception {

       System.out.println("This is new method ");

    }



}