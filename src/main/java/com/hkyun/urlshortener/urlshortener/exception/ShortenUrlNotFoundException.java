package com.hkyun.urlshortener.urlshortener.exception;

public class ShortenUrlNotFoundException extends IllegalArgumentException {
    public ShortenUrlNotFoundException() {
        super();
    }

    public ShortenUrlNotFoundException(String message) {
        super(message);
    }
}
