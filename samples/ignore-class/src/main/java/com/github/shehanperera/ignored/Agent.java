package com.github.shehanperera.ignored;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

/**
 * This is a agent for instrument class that ignored by byte-buddy. Normally byte-buddy ignore java class.
 * From .ignore(ElementMatchers.none()) we can get all running class in floor and we can use .visit for get more
 * details of methods and constructors in these ignored class
 */
public class Agent {

    public static void premain(String arguments, Instrumentation instrumentation) {

        System.out.println("Agent for instrument ignored class like java class ");

        new AgentBuilder.Default()
                .with(new AgentBuilder.InitializationStrategy.SelfInjection.Eager())
                .ignore(ElementMatchers.none())
                .type((ElementMatchers.any()))
                .transform((builder, typeDescription, classLoader, module) -> builder
                        .method(ElementMatchers.any())
                        .intercept(Advice.to(IgnoreClass.class))
                ).installOn(instrumentation);

    }
}
