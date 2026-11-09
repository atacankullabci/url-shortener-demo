package com.atancankullabci.urlshortenerdemo.service;

import com.atancankullabci.urlshortenerdemo.domain.UrlShortenerServiceImpl;
import com.atancankullabci.urlshortenerdemo.ports.out.ConcurrentHashMapRepository;
import com.atancankullabci.urlshortenerdemo.repository.ShortUrlRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanOrganizer {

    @Bean
    public ShortUrlRepository shortUrlRepository() {
        return new ConcurrentHashMapRepository();
    }

    @Bean
    public UrlShortenerService urlShortenerService () {
        return new UrlShortenerServiceImpl(shortUrlRepository()); // neden olmadı bakacağım ??? domain tech ignorant oalcağı için bir şekilde spring e tanıtmak lazım. amacım bu
    }
}
