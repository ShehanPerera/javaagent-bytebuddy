package com.github.shehanperera.addfield;

import net.bytebuddy.asm.Advice;

public class SetField {

    @Advice.OnMethodExit
    public static void enterMethods(@Advice.FieldValue(value = "word") String word, @Advice.FieldValue(value = "number")
            int number) throws Exception {

        System.out.println("This is number before enter method1 " + number);
        System.out.println("This is word before enter method1 " + word);

    }

}