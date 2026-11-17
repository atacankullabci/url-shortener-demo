package com.atancankullabci.urlshortenerdemo.domain;

import com.atancankullabci.urlshortenerdemo.domain.model.ShortUrl;

public interface UrlShortenerService {

    String createHashCode(String longUrl);

    ShortUrl getLongUrl(String hash);
}
