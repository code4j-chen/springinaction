package com.habuma.spitter.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.Map;

/**
 * Created by code4j on 2014/12/12.
 */
@Controller
public class HomeController {
    public static final int DEFAULT_SPITTER_PRE_PAGE = 25;
    private SpitterService spitterService;

    @Inject
    public HomeController(SpitterService spitterService) {
        this.spitterService = spitterService;
    }

    @RequestMapping({"/", "/home"})
    public String showHomePage(Map<String, Object> model) {
        model.put("spittles", spitterService.getRecentSpittles(DEFAULT_SPITTER_PRE_PAGE));
        return "/home";
    }
}
