package com.code4j.springinaction.springidol;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by code4j on 2014/11/22.
 */
@Component("magician")
@Aspect
public class Magician implements MindReader {
    private String thoughts;

    @Pointcut("execution(* com.code4j.springinaction.springidol.Thinker.thinkOfSomething(String)) && args(thoughts)")
    public void thinking(String thoughts) {

    }

    @Before("thinking(thoughts)")
    @Override
    public void interceptThoughts(String thoughts) {
        System.out.println("Intercepting volunteer's thoughts");
        this.thoughts = thoughts;
    }

    @Override
    public String getThoughts() {
        return thoughts;
    }
}
