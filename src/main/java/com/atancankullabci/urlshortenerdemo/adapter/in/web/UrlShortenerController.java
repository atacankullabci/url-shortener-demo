package com.atancankullabci.urlshortenerdemo.adapter.in.web;

import com.atancankullabci.urlshortenerdemo.domain.UrlShortenerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class UrlShortenerController {

    private final String baseUrl;
    private final UrlShortenerService urlShortenerService;

    public UrlShortenerController(@Value("${url.shortener.base-url}") String baseUrl,
                                  UrlShortenerService urlShortenerService) {
        this.baseUrl = baseUrl;
        this.urlShortenerService = urlShortenerService;
    }

    @PostMapping("/api/urls")
    public ResponseEntity<ShortenedUrlResponseDTO> shorten(@RequestBody UrlShortenerRequestDTO requestDTO) {
        String hashCode = this.urlShortenerService.createHashCode(requestDTO.longUrl());
        return ResponseEntity.ok(new ShortenedUrlResponseDTO(baseUrl.concat(hashCode).trim()));
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> redirect(@PathVariable("code") String code) {
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(this.urlShortenerService.getLongUrl(code)));
        // Return HTTP 302 Found
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }

    public record UrlShortenerRequestDTO(String longUrl) {
    }

    public record ShortenedUrlResponseDTO(String shortUrl) {
    }
}
