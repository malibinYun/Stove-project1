package com.hkyun.urlshortener.urlshortener.domain.entity;

import lombok.AllArgsConstructor;
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

    @Column(nullable = false)
    private String value;

    @Column(nullable = false)
    private String originalUrl;

    public ShortUrl(String rawUrl, String originalUrl) {
        this.value = rawUrl;
        this.originalUrl = originalUrl;
    }
}
