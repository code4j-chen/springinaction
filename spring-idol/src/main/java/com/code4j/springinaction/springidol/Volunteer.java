package com.code4j.springinaction.springidol;

import org.springframework.stereotype.Component;

/**
 * Created by code4j on 2014/11/22.
 */
@Component("volunteer")
public class Volunteer implements Thinker {
    private String thoughts;
    @Override
    public void thinkOfSomething(String thoughts) {
        this.thoughts = thoughts;
    }

    public String getThoughts() {
        return thoughts;
    }
}
