package com.atancankullabci.urlshortenerdemo.domain.port.out;

import com.atancankullabci.urlshortenerdemo.domain.model.ShortUrl;

import java.util.Optional;

public interface ShortUrlRepository {

    void save(ShortUrl shortUrl);

    Optional<ShortUrl> get(String hash);
}
