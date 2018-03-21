package com.github.shehanperera.allmethods;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

/**
 *This is the agent for simply get all methods that running in program.
 * To get specific class use : .type((ElementMatchers.named()))
 * To get specific method use : .method(ElementMatchers.named())
 */
public class Agent {

    public static void premain(String arguments, Instrumentation instrumentation) {

        System.out.println("Agent for get all methods");

        new AgentBuilder.Default()
                .with(new AgentBuilder.InitializationStrategy.SelfInjection.Eager())
                .type((ElementMatchers.any()))
                .transform((builder, typeDescription, classLoader, module) -> builder
                        .method(ElementMatchers.any())
                        .intercept(Advice.to(AllMethod.class))
                ).installOn(instrumentation);

    }

}
