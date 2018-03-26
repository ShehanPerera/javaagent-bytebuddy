package com.github.shehanperera.addfield;

import net.bytebuddy.asm.Advice;

public class GetField {

    /**
     * In this class we get the bool and word values before method2 execute
     * method2 should be non-static method.
     */
    @Advice.OnMethodEnter
    public static void getValues(@Advice.FieldValue(value = "bool") boolean bool,
                                 @Advice.FieldValue(value = "word") String word)
            throws Exception {

        System.out.println("Getting New Fields");
        System.out.println("boolean value is " + bool + " and String value is " + word);

    }

}