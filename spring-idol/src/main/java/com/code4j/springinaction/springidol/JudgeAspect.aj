package com.code4j.springinaction.springidol;

/**
 * Created by code4j on 2014/11/24.
 */
public aspect JudgeAspect {
    public JudgeAspect() {
    }

    pointcut performance() : execution(* perform(..));

    after() returning() : performance(){
        System.out.println(criticismEngine.getCriticism());
    }

    private CriticismEngine criticismEngine;

    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }
}
