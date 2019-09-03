package com.sfgexample.mscp.service;

import com.sfgexample.mscp.web.model.CustomerDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomer(UUID customerId);

    CustomerDto save(CustomerDto customerDto);

    CustomerDto update(CustomerDto customerDto);

    void deleteById(UUID customerId);
}
