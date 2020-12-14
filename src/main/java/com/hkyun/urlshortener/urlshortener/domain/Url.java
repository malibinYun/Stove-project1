package com.hkyun.urlshortener.urlshortener.domain;

public class Url {
    private static final int BASE62 = 62;
    private static final String BASE62_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final String HTTP = "http://";
    private static final String HTTPS = "https://";
    public static final String BASE_URL = "http://localhost:8080/";

    private Url() {
    }

    public static String ofShorten(final String rawUrl) {
        String originalUrl = appendHttp(rawUrl);
        System.out.println(rawUrl);
        long decimal = convertDecimal(originalUrl);
        StringBuilder stringBuilder = new StringBuilder(BASE_URL);
        while (decimal > 0) {
            int rem = (int) (decimal % BASE62);
            stringBuilder.append(BASE62_CHARS.charAt(rem));
            decimal /= BASE62;
        }
        return stringBuilder.toString();
    }

    public static String appendHttp(final String rawUrl) {
        if (rawUrl.contains(HTTP) || rawUrl.contains(HTTPS)) {
            return rawUrl;
        }
        return HTTP + rawUrl;
    }

    private static long convertDecimal(String string) {
        long sum = 0;
        for (int i = 1; i <= string.length(); i++) {
            sum += i * (long) string.charAt(i - 1);
        }
        return sum;
    }
}
