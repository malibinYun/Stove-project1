package com.hkyun.urlshortener.urlshortener.controller;

import com.hkyun.urlshortener.urlshortener.controller.dto.ExceptionMessageDto;
import com.hkyun.urlshortener.urlshortener.exception.ShortenUrlNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ExceptionMessageDto unknownError(Exception e) {
        e.printStackTrace();
        return new ExceptionMessageDto("internal server error");
    }

    @ExceptionHandler(ShortenUrlNotFoundException.class)
    public ExceptionMessageDto shortenUrlNotFound(ShortenUrlNotFoundException e) {
        return new ExceptionMessageDto(e.getMessage());
    }
}
