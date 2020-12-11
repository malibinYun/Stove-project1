package com.hkyun.urlshortener.urlshortener.domain;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class UrlShortener {
    private static final int BASE62 = 62;
    private static final String BASE62_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final String HTTP = "http://";
    public static final String BASE_URL = "http://localhost:8080/";

    private UrlShortener() {
    }

    public static String convert(final String rawUrl) {
        String originalUrl = validateUrl(rawUrl);
        long decimal = convertDecimal(originalUrl);
        StringBuilder stringBuilder = new StringBuilder(BASE_URL);
        while (decimal > 0) {
            int rem = (int) decimal % BASE62;
            stringBuilder.append(BASE62_CHARS.charAt(rem));
            decimal /= BASE62;
        }
        return stringBuilder.toString();
    }

    private static String validateUrl(final String rawUrl) {
        if (rawUrl.contains(HTTP)) {
            return HTTP + rawUrl;
        }
        return rawUrl;
    }

    private static long convertDecimal(String string) {
        BigInteger bigInteger = new BigInteger(string.getBytes(StandardCharsets.UTF_8));
        return bigInteger.longValue();
    }
}
