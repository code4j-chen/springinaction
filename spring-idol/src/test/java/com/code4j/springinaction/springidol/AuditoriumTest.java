package com.code4j.springinaction.springidol;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class AuditoriumTest {

    @Test
    public void testMain() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "com/code4j/springinaction/springidol/spring-idol.xml");
        Auditorium auditorium = (Auditorium) context.getBean("auditorium");
        assertNotNull(auditorium);
    }

}