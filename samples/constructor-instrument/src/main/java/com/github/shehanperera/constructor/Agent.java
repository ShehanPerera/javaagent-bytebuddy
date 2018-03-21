package com.github.shehanperera.constructor;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

/**
 * This is Agent for instrument all constructors and methods
 */
public class Agent {

    public static void premain(String arguments, Instrumentation instrumentation) {

        System.out.println("Agent for instrument of constructor");

        new AgentBuilder.Default()
                .with(new AgentBuilder.InitializationStrategy.SelfInjection.Eager())
                .type((ElementMatchers.any()))
                .transform((builder, typeDescription, classLoader, module) -> builder
                        .constructor(ElementMatchers.any())
                        .intercept(Advice.to(Constructor.class))
                        .method(ElementMatchers.any())
                        .intercept(Advice.to(Methods.class))
                ).installOn(instrumentation);

      /*
      OR we can use agent with visit. it will goes to all of constructor and methods

        new AgentBuilder.Default()
                    .with(new AgentBuilder.InitializationStrategy.SelfInjection.Eager())
                .type((ElementMatchers.nameContains("Methods")))
                .transform((builder, typeDescription, classLoader, module) -> builder
                        .visit(Advice.to(Methods.class).on(ElementMatchers.any()))
                ).installOn(instrumentation);
      */
    }
}
