package com.hkyun.urlshortener.urlshortener.service;

import com.hkyun.urlshortener.urlshortener.controller.dto.ShortUrlRequestDto;
import com.hkyun.urlshortener.urlshortener.domain.UrlShortener;
import org.springframework.stereotype.Service;

@Service
public class ShortUrlService {

    public String convertShortUrl(ShortUrlRequestDto requestDto) {
        String rawString = requestDto.getRawUrl().trim();
        return UrlShortener.convert(rawString);
    }
}
