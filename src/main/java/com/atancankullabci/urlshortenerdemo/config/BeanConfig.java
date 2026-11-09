package com.atancankullabci.urlshortenerdemo.config;

import com.atancankullabci.urlshortenerdemo.adapter.out.jpa.JpaShortUrlRepositoryAdapter;
import com.atancankullabci.urlshortenerdemo.adapter.out.jpa.SpringDataJpaShortUrlRepository;
import com.atancankullabci.urlshortenerdemo.adapter.out.memory.ConcurrentHashMapRepository;
import com.atancankullabci.urlshortenerdemo.domain.UrlShortenerService;
import com.atancankullabci.urlshortenerdemo.domain.UrlShortenerServiceImpl;
import com.atancankullabci.urlshortenerdemo.domain.port.out.ShortUrlRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Wires the framework-free domain into Spring. Adapter is chosen by
 * url.shortener.repository = memory (default) | jpa
 */
@Configuration
public class BeanConfig {

    @Bean
    @ConditionalOnProperty(name = "url.shortener.repository", havingValue = "memory", matchIfMissing = true)
    public ShortUrlRepository inMemoryShortUrlRepository() {
        return new ConcurrentHashMapRepository();
    }

    @Bean
    @ConditionalOnProperty(name = "url.shortener.repository", havingValue = "jpa")
    public ShortUrlRepository jpaShortUrlRepository(SpringDataJpaShortUrlRepository springDataRepository) {
        return new JpaShortUrlRepositoryAdapter(springDataRepository);
    }

    @Bean
    public UrlShortenerService urlShortenerService(ShortUrlRepository shortUrlRepository) {
        return new UrlShortenerServiceImpl(shortUrlRepository);
    }
}
