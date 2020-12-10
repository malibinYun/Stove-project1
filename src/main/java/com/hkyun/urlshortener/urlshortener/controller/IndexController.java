package com.hkyun.urlshortener.urlshortener.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String test(Model model) {
        model.addAttribute("shorten", "");
        return "index";
    }
}
