package com.github.shehanperera.addfield;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

/**
 * This is the agent for set and get values form running class
 *
 */
public class Agent {

    public static void premain(String arguments, Instrumentation instrumentation) {

        System.out.println("Agent for Field Adding ");

        new AgentBuilder.Default()
                .with(new AgentBuilder.InitializationStrategy.SelfInjection.Eager())
                .type((ElementMatchers.nameContains("Method")))
                .transform((builder, typeDescription, classLoader, module) -> builder
                        .defineField("word", String.class, Visibility.PUBLIC)
                        .defineField("number", int.class, Visibility.PUBLIC)
                        .method(ElementMatchers.nameContains("method1"))
                        .intercept(Advice.to(SetField.class))
                ).installOn(instrumentation);

    }
}
