package com.code4j.springinaction.springidol;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class StageTest {

    @Test
    public void testGetInstance() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "com/code4j/springinaction/springidol/spring-idol.xml");
        Stage stage = (Stage) context.getBean("stage");
        assertNotNull(stage);
    }
}