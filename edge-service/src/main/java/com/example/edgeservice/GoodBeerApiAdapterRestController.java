package com.example.edgeservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class GoodBeerApiAdapterRestController {

    private final EdgeServiceApplication.BeerClient beerClient;

    public GoodBeerApiAdapterRestController(EdgeServiceApplication.BeerClient beerClient) {
        this.beerClient = beerClient;
    }

    public Collection<EdgeServiceApplication.Beer> fallback() {
        return new ArrayList();

    }

    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/good-beers")
    public Collection<EdgeServiceApplication.Beer> goodBeers() {
        return beerClient.readBeers()
                .getContent()
                .stream()
                .filter(this::isGreat)
                .collect(Collectors.toList());
    }

    private boolean isGreat(EdgeServiceApplication.Beer beer) {

        return !beer.getName().equals("Budweiser") &
                !beer.getName().equals("Coors Light") &
                !beer.getName().equals("PBR");
    }


}
