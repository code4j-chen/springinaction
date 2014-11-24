package com.code4j.springinaction.springidol;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(locations = "classpath:com/code4j/springinaction/springidol/spring-idol.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class VolunteerTest {

    @Autowired
    private Thinker volunteer;

    @Autowired
    private Magician magician;


    @Test
    public void testThinkOfSomething() throws Exception {
        volunteer.thinkOfSomething("Queen of Hearts");
        assertEquals("Queen of Hearts",magician.getThoughts());
    }
}