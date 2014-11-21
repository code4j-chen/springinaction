package com.code4j.springinaction.springidol;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class OnemanBandTest {

    @Test
    public void testPerform() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "com/code4j/springinaction/springidol/spring-idol.xml");
        Performer performer = (Performer) context.getBean("hank");
        performer.perform();
        performer = (Performer) context.getBean("hank1");
        performer.perform();
    }
}