package com.hkyun.urlshortener.urlshortener.service;

import com.hkyun.urlshortener.urlshortener.controller.dto.ShortUrlRequestDto;
import com.hkyun.urlshortener.urlshortener.domain.UrlShortener;
import com.hkyun.urlshortener.urlshortener.domain.entity.ShortUrl;
import com.hkyun.urlshortener.urlshortener.domain.repository.ShortUrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ShortUrlService {

    private final ShortUrlRepository shortUrlRepository;

    public String convertShortUrl(ShortUrlRequestDto requestDto) {
        String rawUrl = requestDto.getRawUrl().trim();
        String shortenUrl = UrlShortener.convert(rawUrl);

        ShortUrl alreadyExist = shortUrlRepository.findByOriginalUrl(rawUrl);
        if (alreadyExist != null) {
            return alreadyExist.getValue();
        }
        ShortUrl entity = new ShortUrl(shortenUrl, rawUrl);
        shortUrlRepository.save(entity);

        return shortenUrl;
    }
}
