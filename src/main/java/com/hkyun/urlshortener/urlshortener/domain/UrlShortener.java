package com.hkyun.urlshortener.urlshortener.domain;

public class UrlShortener {
    private static final int BASE62 = 62;
    private static final String BASE62_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final String BASE_URL = "http://localhost:8080/";

    private UrlShortener() {
    }

    public static String convert(final String rawUrl) {
        long decimal = convertDecimal(rawUrl);
        StringBuilder stringBuilder = new StringBuilder(BASE_URL);
        while (decimal > 0) {
            int rem = (int) decimal % BASE62;
            stringBuilder.append(BASE62_CHARS.charAt(rem));
            decimal /= BASE62;
        }
        return stringBuilder.toString();
    }

    private static long convertDecimal(String string) {
        return string.chars().sum();
    }
}
