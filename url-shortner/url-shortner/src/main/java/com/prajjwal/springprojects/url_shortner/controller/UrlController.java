package com.prajjwal.springprojects.url_shortner.controller;

import com.prajjwal.springprojects.url_shortner.dtos.ShortenUrlRequest;
import com.prajjwal.springprojects.url_shortner.service.UrlService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/urls")
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService)
    {
        this.urlService=urlService;
    }

    @PostMapping("/shorten")
    public ResponseEntity<String> shortenUrl(@RequestBody ShortenUrlRequest request){

        String strategy=request.shortenStrategy();
        String shortUrl= urlService.getShortenUrl(request.longUrl(),strategy);

        return ResponseEntity.accepted().body(shortUrl);
        
    }

    @GetMapping("/decode/{shortUrl}")
    public ResponseEntity<String> decodeUrl(@PathVariable("shortUrl") String shortUrl)
    {
       String longUrl=urlService.decodeUrl(shortUrl);

       return ResponseEntity.accepted().body(longUrl);

    }

}
