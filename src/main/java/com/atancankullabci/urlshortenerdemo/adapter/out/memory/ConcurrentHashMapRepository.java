package com.atancankullabci.urlshortenerdemo.adapter.out.memory;

import com.atancankullabci.urlshortenerdemo.domain.model.ShortUrl;
import com.atancankullabci.urlshortenerdemo.domain.port.out.ShortUrlRepository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapRepository implements ShortUrlRepository {

    private final Map<String, ShortUrl> mapRepo = new ConcurrentHashMap<>();

    @Override
    public void save(ShortUrl shortUrl) {
        mapRepo.putIfAbsent(shortUrl.hash(), shortUrl);
    }

    @Override
    public Optional<ShortUrl> get(String hash) {
        return Optional.empty();
    }
}
