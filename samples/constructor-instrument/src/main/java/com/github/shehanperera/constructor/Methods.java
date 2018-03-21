package com.github.shehanperera.constructor;

import net.bytebuddy.asm.Advice;

public class Methods {

    @Advice.OnMethodEnter
    static long enterMethods() throws Exception {

        long start = System.currentTimeMillis();
        return start;
    }

    @Advice.OnMethodExit
    static void exitMethods(@Advice.Origin String method, @Advice.Enter long start) throws Exception {

        long end = System.currentTimeMillis();
        System.out.println("This is Method :" + method + "took " + (end-start) + " milliseconds ");
    }

}