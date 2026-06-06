package com.prajjwal.springprojects.url_shortner.service;

import com.prajjwal.springprojects.url_shortner.factory.UrlShortnerFactory;
import com.prajjwal.springprojects.url_shortner.modals.UrlModal;
import com.prajjwal.springprojects.url_shortner.repository.UrlRepository;
import com.prajjwal.springprojects.url_shortner.strategy.ShortenUrlStrategy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class UrlService {

    private final UrlShortnerFactory urlShortnerFactory;

    private final UrlRepository urlRepository;

    public UrlService(UrlShortnerFactory urlShortnerFactory,UrlRepository urlRepository)
    {
        this.urlShortnerFactory=urlShortnerFactory;
        this.urlRepository=urlRepository;
    }

    public String getShortenUrl(String longUrl,String shortenStrategy)
    {

        ShortenUrlStrategy shortenUrlStrategy=urlShortnerFactory.getStrategy(shortenStrategy);

        String shortUrl=shortenUrlStrategy.shortenUrl(longUrl);

        boolean isSaved=saveToDB(longUrl,shortUrl);

        System.out.println("Url is "+isSaved);

        return shortUrl;

    }

    private boolean saveToDB(String longUrl,String shortUrl)
    {
        UrlModal urlModal= UrlModal.builder().
                longUrl(longUrl)
                .dateAdded(LocalDate.now())
                .shortUrl(shortUrl).build();

        try {
            urlRepository.save(urlModal);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }

        return true;

    }

    public String decodeUrl(String shortUrl)
    {

      UrlModal modal=urlRepository.findByShortUrl(shortUrl).orElse(null);

      if(modal!=null)
      {
          return modal.getLongUrl();
      }

      return "No url found";

    }
}
