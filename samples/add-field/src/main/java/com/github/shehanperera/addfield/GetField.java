package com.github.shehanperera.addfield;

import net.bytebuddy.asm.Advice;

public class GetField {

    @Advice.OnMethodEnter
    public static void exit(@Advice.FieldValue(value = "bool") boolean bool,
                            @Advice.FieldValue(value = "word") String word)
            throws Exception {

        System.out.println("Getting New Fields");
        System.out.println("boolean value is " + bool + " and String value is " + word);

    }

}