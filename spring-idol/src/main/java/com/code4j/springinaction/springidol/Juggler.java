package com.code4j.springinaction.springidol;

/**
 * Created by code4j on 2014/11/20.
 */
public class Juggler implements Performer {
    private int beanBags = 3;

    public Juggler() {
    }

    public Juggler(int beanBags) {
        this.beanBags = beanBags;
    }

    @Override
    public void perform() throws PerformerException {
        System.out.println("JUGGLING " + beanBags + " BEANBAGS");
    }
}
