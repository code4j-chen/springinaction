package com.code4j.springinaction.springidol;

/**
 * Created by code4j on 2014/11/20.
 */
public class PoeticJuggler extends Juggler {
    private Poem poem;

    public PoeticJuggler(Poem poem) {
        super();
        this.poem = poem;
    }

    public PoeticJuggler(int beanBags, Poem poem) {
        super(beanBags);
        this.poem = poem;
    }

    @Override
    public void perform() throws PerformerException {
        super.perform();
        System.out.println("While reciting...");
        poem.recite();
    }
}
