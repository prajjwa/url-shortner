package com.prajjwal.springprojects.url_shortner.strategy;

import com.prajjwal.springprojects.url_shortner.enums.ShortenUrlEnum;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Base62Shorten implements ShortenUrlStrategy {

    private String encodeToBase62(long code){

        String chars =
                "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        StringBuilder stringBuilder=new StringBuilder();

        while(code>0)
        {
            stringBuilder.append(chars.charAt((int) (code%62) ));
            code/=62;
        }

        return stringBuilder.reverse().toString();

    }


public long decodeUrl(String shortUrl)
{

    long code=0;

    int len=shortUrl.length();

    for(int i=0;i<len;i++)
    {
        int num=(int) (shortUrl.charAt(i)-'0');
        code+=num*(int)Math.pow(62,i);
    }

    return code;


}



    @Override
    public String shortenUrl(String longUrl) {

        long code=Math.abs(UUID.randomUUID().getMostSignificantBits());

        return encodeToBase62(code);
    }

    @Override
    public ShortenUrlEnum getType() {
        return ShortenUrlEnum.BASE62;
    }
}
