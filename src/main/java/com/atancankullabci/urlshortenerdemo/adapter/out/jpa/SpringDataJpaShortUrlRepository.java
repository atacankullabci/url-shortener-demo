package com.atancankullabci.urlshortenerdemo.adapter.out.jpa;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SpringDataJpaShortUrlRepository extends CrudRepository<ShortUrlEntity, Long> {

    Optional<ShortUrlEntity> findByHash(String hash);
}
