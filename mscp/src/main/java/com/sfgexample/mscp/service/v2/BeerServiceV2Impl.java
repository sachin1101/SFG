package com.sfgexample.mscp.service.v2;

import com.sfgexample.mscp.service.BeerService;
import com.sfgexample.mscp.web.model.BeerDto;
import com.sfgexample.mscp.web.model.v2.BeerDtoV2;
import com.sfgexample.mscp.web.model.v2.BeerStyleEnum;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder().id(beerId)
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleEnum.ALE)
                .upc(Math.round(Math.random()*100000))
                .build();

    }

    @Override
    public BeerDtoV2 save(BeerDtoV2 beerDto) {
        return beerDto;
    }

    @Override
    public void update(UUID beerId, BeerDtoV2 beerDto) {

    }

    @Override
    public void deleteById(UUID beerId) {

    }
}
