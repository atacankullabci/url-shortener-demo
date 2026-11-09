package com.atancankullabci.urlshortenerdemo.repository;

import com.atancankullabci.urlshortenerdemo.entity.ShortUrl;

import java.util.Optional;

public interface ShortUrlRepository {

    void save(ShortUrl shortUrl);

    Optional<ShortUrl> get(String hash);
}
