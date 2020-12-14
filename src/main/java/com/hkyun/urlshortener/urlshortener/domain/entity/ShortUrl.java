package com.hkyun.urlshortener.urlshortener.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity
public class ShortUrl {

    @Id
    @GeneratedValue()
    private Long id;

    @Column(nullable = false, unique = true)
    private String value;

    @Column(nullable = false)
    private String originalUrl;

    @Column(nullable = false)
    private Long requestCount;

    public ShortUrl(String rawUrl, String originalUrl) {
        this.value = rawUrl;
        this.originalUrl = originalUrl;
        this.requestCount = 1L;
    }

    public void countUp() {
        requestCount++;
    }
}
