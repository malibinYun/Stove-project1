package com.hkyun.urlshortener.urlshortener.service;

import com.hkyun.urlshortener.urlshortener.controller.dto.ShortUrlRequestDto;
import com.hkyun.urlshortener.urlshortener.domain.Url;
import com.hkyun.urlshortener.urlshortener.domain.entity.ShortUrl;
import com.hkyun.urlshortener.urlshortener.domain.repository.ShortUrlRepository;
import com.hkyun.urlshortener.urlshortener.exception.ShortenUrlNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ShortUrlService {

    private final ShortUrlRepository shortUrlRepository;

    @Transactional
    public String getShortUrl(ShortUrlRequestDto requestDto) {
        String originalUrl = Url.appendHttp(requestDto.getRawUrl().trim());
        String shortenUrl = Url.ofShorten(originalUrl);

        Optional<ShortUrl> alreadyExist = shortUrlRepository.findByOriginalUrl(originalUrl);
        if (alreadyExist.isPresent()) {
            ShortUrl existUrl = alreadyExist.get();
            existUrl.countUp();
            shortUrlRepository.save(existUrl);
            return existUrl.getValue();
        }
        saveShortUrl(shortenUrl, originalUrl);
        return shortenUrl;
    }

    private void saveShortUrl(String shortenUrl, String rawUrl) {
        ShortUrl entity = new ShortUrl(shortenUrl, rawUrl);
        shortUrlRepository.save(entity);
    }

    public String getOriginalUrl(String shortenKey) {
        String shortenUrl = Url.BASE_URL + shortenKey;
        return shortUrlRepository.findByValue(shortenUrl)
                .orElseThrow(() -> new ShortenUrlNotFoundException(String.format("Cannot redirect this Url : %s", shortenUrl)))
                .getOriginalUrl();
    }
}
