package com.hkyun.urlshortener.urlshortener.service;

import com.hkyun.urlshortener.urlshortener.controller.dto.ShortUrlRequestDto;
import org.springframework.stereotype.Service;

@Service
public class ShortUrlService {

    public String convertShortUrl(ShortUrlRequestDto requestDto) {
        return requestDto.getRawUrl() + " is shorten";
    }
}
