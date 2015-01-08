package com.habuma.spitter.mvc;

import org.junit.Test;

import java.util.*;

import org.mockito.Mockito;

import static org.junit.Assert.*;

public class HomeControllerTest {
    public static final int DEFAULT_SPITTERS_PRE_PAGE = 25;
    @Test
    public void testShowHomePage() throws Exception {
        List<Spittle> expectedSpittles = Arrays.asList(new Spittle(), new Spittle(), new Spittle());
        SpitterService spitterService = Mockito.mock(SpitterService.class);
        Mockito.when(spitterService.getRecentSpittles(DEFAULT_SPITTERS_PRE_PAGE)).thenReturn(expectedSpittles);
        HomeController homeController = new HomeController(spitterService);
        Map<String, Object> model = new HashMap<>();
        String viewName = homeController.showHomePage(model);
        assertEquals("home", viewName);
        assertSame(expectedSpittles, model.get("spittles"));
        Mockito.verify(spitterService).getRecentSpittles(DEFAULT_SPITTERS_PRE_PAGE);
    }
}