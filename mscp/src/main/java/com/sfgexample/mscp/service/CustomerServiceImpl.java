package com.sfgexample.mscp.service;

import com.sfgexample.mscp.web.model.CustomerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Override
    public CustomerDto getCustomer(UUID customerId) {
        return  CustomerDto.builder().id(customerId)
                .name("John Smith").build();
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        return customerDto;
    }

    @Override
    public CustomerDto update(CustomerDto customerDto) {
        return customerDto;
    }

    @Override
    public void deleteById(UUID customerId) {

    }
}
