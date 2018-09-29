package com.github.shehanperera.ignored;

import net.bytebuddy.asm.Advice;

public class IgnoreClass {

    @Advice.OnMethodExit
    public static void enterMethods(@Advice.Origin String method) throws Exception {

        System.out.println("method "+ method);

    }

}