package com.github.shehanperera.addfield;

import net.bytebuddy.asm.Advice;

public class GetField {

    @Advice.OnMethodExit
    static void exitMethods(@Advice.FieldValue(value = "word") String word, @Advice.FieldValue(value = "number")
            int number) throws Exception {

        System.out.println("This is number after exit method2 " + number);
        System.out.println("This is word after exit method2 " + word);

    }



}