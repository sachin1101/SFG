package com.sfgexample.mscp.web.controller;

import com.sfgexample.mscp.service.CustomerService;
import com.sfgexample.mscp.web.model.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customer/api/v1")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/get/{customerId}")
    public ResponseEntity<CustomerDto>getCustomer(@PathVariable("customerId") UUID customerId )
    {

       CustomerDto customerDto =  this.customerService.getCustomer(customerId);
        return  new ResponseEntity(customerDto, HttpStatus.OK);
    }

    @PostMapping("/{customerId}")
    public ResponseEntity updateCustomer(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDto customerDto){
        CustomerDto updatedCustomerDto = this.customerService.update(customerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("createdUrl", "/customer/api/v1/get/ "+ updatedCustomerDto.getId() );
        return  new ResponseEntity(headers, HttpStatus.CREATED);



    }


    @PutMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody CustomerDto customerDto)
    {
        CustomerDto createdCustomerDto = this.customerService.save(customerDto);

    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCustomer(@PathVariable UUID customerId){
        this.customerService.deleteById(customerId);

    }
}
