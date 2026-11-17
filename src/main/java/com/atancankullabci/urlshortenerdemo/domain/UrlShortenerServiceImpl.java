package com.atancankullabci.urlshortenerdemo.domain;

import com.atancankullabci.urlshortenerdemo.domain.model.ShortUrl;
import com.atancankullabci.urlshortenerdemo.domain.port.out.ShortUrlRepository;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Spring ignorant or any other tech stack ignorant. base functionality is creating a hash from the url, and returning a url from the hash.
 * Nothing to depend on !!!
 */
public class UrlShortenerServiceImpl implements UrlShortenerService {

    private final ShortUrlRepository shortUrlRepository;
    private AtomicLong atomicId = new AtomicLong(0L);


    public UrlShortenerServiceImpl(ShortUrlRepository shortUrlRepository) {
        this.shortUrlRepository = shortUrlRepository;
    }

    @Override
    public String createHashCode(String longUrl) {
        long id = atomicId.incrementAndGet();
        String encode = Base62.encode(id);
        shortUrlRepository.save(new ShortUrl(id, longUrl, encode, Instant.now()));
        return encode;
    }

    @Override
    public ShortUrl getLongUrl(String hash) {
        return shortUrlRepository.get(hash).orElse(null);
    }


}
