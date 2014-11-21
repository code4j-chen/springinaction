package com.code4j.springinaction.springidol;

/**
 * Created by code4j on 2014/11/20.
 */
public class Sonnet29 implements Poem {

    private static String[] LINES = {
            "1", "2", "3"
    };

    @Override
    public void recite() {
        for (int i = 0; i < LINES.length; i++) {
            System.out.println(LINES[i]);
        }
    }
}
