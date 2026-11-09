package com.atancankullabci.urlshortenerdemo.domain.model;

import java.time.Instant;

/**
 * Pure domain model — no framework annotations.
 */
public record ShortUrl(Long id, String longUrl, String hash, Instant createdAt) {
}
