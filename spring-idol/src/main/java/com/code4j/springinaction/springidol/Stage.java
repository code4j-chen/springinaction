package com.code4j.springinaction.springidol;

/**
 * Created by code4j on 2014/11/21.
 */
public class Stage {

    public static Stage getInstance() {
        return StageSingletonHolder.instance;
    }

    private static class StageSingletonHolder {
        static Stage instance = new Stage();
    }

    private Stage() {
    }
}
