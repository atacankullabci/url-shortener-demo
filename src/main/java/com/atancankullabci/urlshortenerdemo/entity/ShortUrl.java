package com.atancankullabci.urlshortenerdemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.Instant;

@Entity
@Table
@Data
public class ShortUrl {
    @Id
    private Long id;
    private String longURL;
    private String hash;
    private Instant createdAt;
}
