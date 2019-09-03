package com.sfgexample.mscp.service.v2;

import com.sfgexample.mscp.web.model.BeerDto;
import com.sfgexample.mscp.web.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {
    BeerDtoV2 getBeerById(UUID beerId);

    BeerDtoV2 save(BeerDtoV2 beerDto);

    void update(UUID beerId, BeerDtoV2 beerDto);

    void deleteById(UUID beerId);
}
