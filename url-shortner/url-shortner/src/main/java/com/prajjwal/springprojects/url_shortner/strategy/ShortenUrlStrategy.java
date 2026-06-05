package com.prajjwal.springprojects.url_shortner.strategy;

import com.prajjwal.springprojects.url_shortner.enums.ShortenUrlEnum;

public interface ShortenUrlStrategy {

    String shortenUrl(String longUrl);

    ShortenUrlEnum getType();
}
