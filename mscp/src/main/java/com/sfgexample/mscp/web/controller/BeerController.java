package com.sfgexample.mscp.web.controller;

import com.sfgexample.mscp.service.BeerService;
import com.sfgexample.mscp.web.model.BeerDto;
import com.sfgexample.mscp.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private BeerService beerService;

    @Autowired
    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){

        return new ResponseEntity<>(this.beerService.getBeerById(beerId), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity saveBeer(@RequestBody BeerDto beerDto)
    {
        BeerDto savedBeerDto = this.beerService.save(beerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "GET /api/v1/beer/" +savedBeerDto.getId().toString() );
        return  new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeer(@RequestBody BeerDto beerDto, @PathVariable("beerId") UUID beerId)
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
