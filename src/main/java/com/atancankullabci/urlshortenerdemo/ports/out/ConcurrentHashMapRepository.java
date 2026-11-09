package com.atancankullabci.urlshortenerdemo.ports.out;

import com.atancankullabci.urlshortenerdemo.entity.ShortUrl;
import com.atancankullabci.urlshortenerdemo.repository.ShortUrlRepository;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ConcurrentHashMapRepository implements ShortUrlRepository {

    private final Map<String, ShortUrl> mapRepo = new ConcurrentHashMap<>();

    @Override
    public void save(ShortUrl shortUrl) {
        mapRepo.putIfAbsent(shortUrl.getHash(), shortUrl);
    }

    @Override
    public Optional<ShortUrl> get(String hash) {
        return Optional.empty();
    }
}
