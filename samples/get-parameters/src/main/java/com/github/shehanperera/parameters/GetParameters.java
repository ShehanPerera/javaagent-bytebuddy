package com.github.shehanperera.parameters;

import net.bytebuddy.asm.Advice;

public class GetParameters {

    @Advice.OnMethodExit
    public static void getParametrs(@Advice.Origin String method, @Advice.AllArguments Object[] para) throws Exception {

        System.out.println(method);
        /*This is use for get class of parameters to get
        *an idea what we can do using this advice
        */
        System.out.println("Class names of parameters");
        for (int i = 0; i < 3; i++) {
            System.out.println(para[i].getClass());
        }
        /*
        This is a way we can access to each parameters separately using agent advice
        For this we want an idea about parameters class , so from above we can get class of parameters and we can use
         them as follows or as we need.
         */
        System.out.println("Get parameters values");
        int number = (int) para[0];
        System.out.println("number is :" + number);
        String name = (String) para[1];
        System.out.println("name is :" + name);
        boolean run = (boolean) para[2];
        System.out.println("run is :" + run);

    }

}