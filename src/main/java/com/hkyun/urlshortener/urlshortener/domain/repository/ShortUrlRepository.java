package com.hkyun.urlshortener.urlshortener.domain.repository;

import com.hkyun.urlshortener.urlshortener.domain.entity.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortUrlRepository extends JpaRepository<ShortUrl, Long> {

    ShortUrl findByOriginalUrl(String originalUrl);
}
