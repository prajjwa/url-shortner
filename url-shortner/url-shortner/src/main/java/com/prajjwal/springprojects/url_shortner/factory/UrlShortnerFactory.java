package com.prajjwal.springprojects.url_shortner.factory;

import com.prajjwal.springprojects.url_shortner.enums.ShortenUrlEnum;
import com.prajjwal.springprojects.url_shortner.strategy.ShortenUrlStrategy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class UrlShortnerFactory {

    private final Map<ShortenUrlEnum, ShortenUrlStrategy> mapOfStrategy;

    public UrlShortnerFactory(List<ShortenUrlStrategy> shortenUrlStrategyList)
    {
       mapOfStrategy=shortenUrlStrategyList.stream()
                .collect(Collectors.toMap(
                    ShortenUrlStrategy::getType, Function.identity()
                ));
    }

    public ShortenUrlStrategy getStrategy(String strategy)
    {
        return mapOfStrategy.get(ShortenUrlEnum.valueOf(strategy));
    }


}
