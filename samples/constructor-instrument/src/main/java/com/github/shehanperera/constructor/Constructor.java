package com.github.shehanperera.constructor;

import net.bytebuddy.asm.Advice;

public class Constructor {

    @Advice.OnMethodEnter
    static long enterConstructor() throws Exception {

        long start = System.currentTimeMillis();
        return start;
    }

    @Advice.OnMethodExit
    static void exitConstructor(@Advice.Origin String method, @Advice.Enter long start) throws Exception {

        long end = System.currentTimeMillis();
        System.out.println("This is Constructor :" + method + "took " + (end-start) + " milliseconds ");
    }

}