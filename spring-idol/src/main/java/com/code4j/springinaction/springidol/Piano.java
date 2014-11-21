package com.code4j.springinaction.springidol;

/**
 * Created by code4j on 2014/11/21.
 */
public class Piano implements Instrument {
    @Override
    public void play() {
        System.out.println("PLINK PLINK PLINK");
    }
}
