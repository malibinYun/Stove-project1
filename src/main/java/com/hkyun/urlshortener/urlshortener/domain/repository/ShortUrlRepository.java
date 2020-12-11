package com.hkyun.urlshortener.urlshortener.domain.repository;

import com.hkyun.urlshortener.urlshortener.domain.entity.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShortUrlRepository extends JpaRepository<ShortUrl, Long> {

    Optional<ShortUrl> findByOriginalUrl(String originalUrl);

    Optional<ShortUrl> findByValue(String shortenUrl);
}
