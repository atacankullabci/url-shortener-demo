package com.atancankullabci.urlshortenerdemo.domain;

import com.atancankullabci.urlshortenerdemo.domain.port.out.ShortUrlRepository;

/**
 * Spring ignorant or any other tech stack ignorant. base functionality is creating a hash from the url, and returning a url from the hash.
 * Nothing to depend on !!!
 */
public class UrlShortenerServiceImpl implements UrlShortenerService {

    private final ShortUrlRepository shortUrlRepository;

    public UrlShortenerServiceImpl(ShortUrlRepository shortUrlRepository) {
        this.shortUrlRepository = shortUrlRepository;
    }

    @Override
    public String createHashCode(String longUrl) {
        return "";
    }

    @Override
    public String getLongUrl(String hash) {
        return "";
    }
}
