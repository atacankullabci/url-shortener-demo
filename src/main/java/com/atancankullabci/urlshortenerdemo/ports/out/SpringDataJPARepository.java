package com.atancankullabci.urlshortenerdemo.ports.out;

import com.atancankullabci.urlshortenerdemo.entity.ShortUrl;
import com.atancankullabci.urlshortenerdemo.repository.ShortUrlRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpringDataJPARepository implements ShortUrlRepository {

    private final SpringDataJpaShortUrlRepository springDataJpaShortUrlRepository;

    public SpringDataJPARepository(SpringDataJpaShortUrlRepository springDataJpaShortUrlRepository) {
        this.springDataJpaShortUrlRepository = springDataJpaShortUrlRepository;
    }

    @Override
    public void save(ShortUrl shortUrl) {
        springDataJpaShortUrlRepository.save(shortUrl);
    }

    @Override
    public Optional<ShortUrl> get(String hash) {
        return this.springDataJpaShortUrlRepository.findByHash(hash);
    }
}
