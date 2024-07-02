package com.electricity.bill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electricity.bill.dto.CustomerDto;
import com.electricity.bill.services.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customers")
@Validated
public class CustomerController {
	
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<CustomerDto>createCustomer(@Valid @RequestBody CustomerDto customerDto){
		CustomerDto savedCustomerDto=customerService.createCustomer(customerDto);
		return new ResponseEntity<>(savedCustomerDto,HttpStatus.CREATED);
	}

}
