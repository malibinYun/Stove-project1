package com.hkyun.urlshortener.urlshortener.controller;

import com.hkyun.urlshortener.urlshortener.service.ShortUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final ShortUrlService shortUrlService;

    @RequestMapping("/")
    public String showMainPage(Model model) {
        model.addAttribute("shorten", "");
        return "index";
    }

    @RequestMapping("/{shortenKey}")
    public RedirectView redirectPage(@PathVariable String shortenKey) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(shortUrlService.getOriginalUrl(shortenKey));
        return redirectView;
    }
}
