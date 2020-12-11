package com.hkyun.urlshortener.urlshortener.controller;

import com.hkyun.urlshortener.urlshortener.controller.dto.ShortUrlRequestDto;
import com.hkyun.urlshortener.urlshortener.service.ShortUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ShortUrlController {

    private final ShortUrlService shortUrlService;

    @PostMapping("/api/url/short")
    public String getShortenUrl(@RequestBody ShortUrlRequestDto requestDto) {
        return shortUrlService.getShortUrl(requestDto);
    }
}
