package com.hkyun.urlshortener.urlshortener.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ShortUrlRequestDto {
    private String rawUrl;
}
