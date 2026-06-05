package com.prajjwal.springprojects.url_shortner.strategy;

import com.prajjwal.springprojects.url_shortner.enums.ShortenUrlEnum;
import org.springframework.stereotype.Component;

@Component
public class RandomShorten implements ShortenUrlStrategy{
    @Override
    public String shortenUrl(String longUrl) {
        return null;
    }

    @Override
    public ShortenUrlEnum getType() {
        return ShortenUrlEnum.RANDOM;
    }
}
