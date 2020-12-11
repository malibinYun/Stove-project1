package com.hkyun.urlshortener.urlshortener.service;

import com.hkyun.urlshortener.urlshortener.controller.dto.ShortUrlRequestDto;
import com.hkyun.urlshortener.urlshortener.domain.UrlShortener;
import com.hkyun.urlshortener.urlshortener.domain.entity.ShortUrl;
import com.hkyun.urlshortener.urlshortener.domain.repository.ShortUrlRepository;
import com.hkyun.urlshortener.urlshortener.exception.ShortenUrlNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ShortUrlService {

    private final ShortUrlRepository shortUrlRepository;

    public String getShortUrl(ShortUrlRequestDto requestDto) {
        String rawUrl = requestDto.getRawUrl().trim();
        String shortenUrl = UrlShortener.convert(rawUrl);

        Optional<ShortUrl> alreadyExist = shortUrlRepository.findByOriginalUrl(rawUrl);
        if (alreadyExist.isPresent()) {
            return alreadyExist.get().getValue();
        }
        saveShortUrl(shortenUrl, rawUrl);
        return shortenUrl;
    }

    private void saveShortUrl(String shortenUrl, String rawUrl) {
        ShortUrl entity = new ShortUrl(shortenUrl, rawUrl);
        shortUrlRepository.save(entity);
    }

    public String getOriginalUrl(String shortenKey) {
        String shortenUrl = UrlShortener.BASE_URL + shortenKey;
        return shortUrlRepository.findByValue(shortenUrl)
                .orElseThrow(() -> new ShortenUrlNotFoundException(String.format("Cannot redirect this Url : %s", shortenUrl)))
                .getOriginalUrl();
    }
}
