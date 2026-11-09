package com.atancankullabci.urlshortenerdemo.adapter.out.jpa;

import com.atancankullabci.urlshortenerdemo.domain.model.ShortUrl;
import com.atancankullabci.urlshortenerdemo.domain.port.out.ShortUrlRepository;

import java.util.Optional;

public class JpaShortUrlRepositoryAdapter implements ShortUrlRepository {

    private final SpringDataJpaShortUrlRepository springDataRepository;

    public JpaShortUrlRepositoryAdapter(SpringDataJpaShortUrlRepository springDataRepository) {
        this.springDataRepository = springDataRepository;
    }

    @Override
    public void save(ShortUrl shortUrl) {
        springDataRepository.save(ShortUrlEntityMapper.toEntity(shortUrl));
    }

    @Override
    public Optional<ShortUrl> get(String hash) {
        return springDataRepository.findByHash(hash).map(ShortUrlEntityMapper::toDomain);
    }
}
