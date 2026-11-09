package com.atancankullabci.urlshortenerdemo.service;

public interface UrlShortenerService {
    String createHashCode(String longUrl);

    String getLongUrl(String hash);
}
