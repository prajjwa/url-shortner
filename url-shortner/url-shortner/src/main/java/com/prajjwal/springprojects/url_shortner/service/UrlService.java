package com.prajjwal.springprojects.url_shortner.service;


import com.prajjwal.springprojects.url_shortner.enums.ShortenUrlEnum;
import com.prajjwal.springprojects.url_shortner.factory.UrlShortnerFactory;
import com.prajjwal.springprojects.url_shortner.strategy.ShortenUrlStrategy;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

    private final UrlShortnerFactory urlShortnerFactory;

    public UrlService(UrlShortnerFactory urlShortnerFactory)
    {
        this.urlShortnerFactory=urlShortnerFactory;
    }

    public String getShortenUrl(String longUrl,String shortenStrategy)
    {

        ShortenUrlStrategy shortenUrlStrategy=urlShortnerFactory.getStrategy(shortenStrategy);

        return shortenUrlStrategy.shortenUrl(longUrl);

    }
}
