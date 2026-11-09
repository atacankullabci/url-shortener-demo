package com.atancankullabci.urlshortenerdemo.domain;

public interface UrlShortenerService {

    String createHashCode(String longUrl);

    String getLongUrl(String hash);
}
