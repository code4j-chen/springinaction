package com.code4j.springinaction;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BraveKnightTest {

    @Test
    public void testEmbarkOnQuest() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("knights.xml");
        Knight knight = (Knight)context.getBean("knight");
        knight.embarkOnQuest();
    }
}