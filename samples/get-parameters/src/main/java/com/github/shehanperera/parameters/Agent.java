package com.github.shehanperera.parameters;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

/**
 * This an agent for instrument method4 in Method class and get parameters of method4
 */
public class Agent {

    public static void premain(String arguments, Instrumentation instrumentation) {

        System.out.println("Agent for get parameters in method 4");

        new AgentBuilder.Default()
                .ignore(ElementMatchers.none())
                .type(ElementMatchers.nameContains("Method"))
                .transform((builder, type, classLoader, module) -> builder
                        .method(ElementMatchers.nameContains("method4"))
                        .intercept(Advice.to(GetParameters.class))
                ).installOn(instrumentation);

    }
}
