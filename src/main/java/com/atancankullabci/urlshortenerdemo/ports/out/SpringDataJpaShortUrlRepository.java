package com.atancankullabci.urlshortenerdemo.ports.out;

import com.atancankullabci.urlshortenerdemo.entity.ShortUrl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataJpaShortUrlRepository extends CrudRepository<ShortUrl, Long> {
    Optional<ShortUrl> findByHash(String hash);
}
