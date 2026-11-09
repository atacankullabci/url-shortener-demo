package com.atancankullabci.urlshortenerdemo.adapter.out.jpa;

import com.atancankullabci.urlshortenerdemo.domain.model.ShortUrl;

final class ShortUrlEntityMapper {

    private ShortUrlEntityMapper() {
    }

    static ShortUrlEntity toEntity(ShortUrl shortUrl) {
        ShortUrlEntity entity = new ShortUrlEntity();
        entity.setId(shortUrl.id());
        entity.setLongUrl(shortUrl.longUrl());
        entity.setHash(shortUrl.hash());
        entity.setCreatedAt(shortUrl.createdAt());
        return entity;
    }

    static ShortUrl toDomain(ShortUrlEntity entity) {
        return new ShortUrl(entity.getId(), entity.getLongUrl(), entity.getHash(), entity.getCreatedAt());
    }
}
