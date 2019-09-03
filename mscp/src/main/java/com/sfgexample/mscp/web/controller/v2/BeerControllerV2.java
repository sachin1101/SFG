package com.sfgexample.mscp.web.controller.v2;

import com.sfgexample.mscp.service.BeerService;
import com.sfgexample.mscp.service.v2.BeerServiceV2;
import com.sfgexample.mscp.web.model.BeerDto;
import com.sfgexample.mscp.web.model.v2.BeerDtoV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v2/beer")
public class BeerControllerV2 {

    private BeerServiceV2 beerService;

    @Autowired
    public BeerControllerV2(BeerServiceV2 beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId){

        return new ResponseEntity<>(this.beerService.getBeerById(beerId), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity saveBeer(@RequestBody BeerDtoV2 beerDto)
    {
        BeerDtoV2 savedBeerDto = this.beerService.save(beerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "GET /api/v1/beer/" +savedBeerDto.getId().toString() );
        return  new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeer(@RequestBody BeerDtoV2 beerDto, @PathVariable("beerId") UUID beerId)
    {
        this.beerService.update(beerId, beerDto);

        return  new ResponseEntity(HttpStatus.NO_CONTENT);


    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
        beerService.deleteById(beerId);
    }
}
