package com.github.shehanperera.allmethods;

import net.bytebuddy.asm.Advice;

public class AllMethod {

    @Advice.OnMethodExit
    static void getAllMethods(@Advice.Origin String method) throws Exception {

        System.out.println(method);
    }

}