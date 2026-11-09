package com.atancankullabci.urlshortenerdemo.adapter.out.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "short_url")
@Getter
@Setter
@NoArgsConstructor
public class ShortUrlEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 2048)
    private String longUrl;

    @Column(unique = true)
    private String hash;

    @Column(nullable = false)
    private Instant createdAt;
}
