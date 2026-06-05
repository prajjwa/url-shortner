package com.prajjwal.springprojects.url_shortner.dtos;

import lombok.Data;

public record ShortenUrlRequest(String longUrl,String shortenStrategy) {

}
