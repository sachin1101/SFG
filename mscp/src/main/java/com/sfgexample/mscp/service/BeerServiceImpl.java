package com.sfgexample.mscp.service;

import com.sfgexample.mscp.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(beerId)
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .upc(Math.round(Math.random()*100000))
                .build();

    }

    @Override
    public BeerDto save(BeerDto beerDto) {
        return beerDto;
    }

    @Override
    public void update(UUID beerId, BeerDto beerDto) {

    }

    @Override
    public void deleteById(UUID beerId) {

    }
}
