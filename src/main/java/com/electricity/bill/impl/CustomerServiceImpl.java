package com.electricity.bill.impl;

import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electricity.bill.dto.CustomerDto;
import com.electricity.bill.entity.Customer;
import com.electricity.bill.exceptions.InvalidEmailException;
import com.electricity.bill.exceptions.ResourceAlreadyExistsException;
import com.electricity.bill.mapper.CustomerMapper;
import com.electricity.bill.repository.CustomerRepository;
import com.electricity.bill.services.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	private static final String EMAIL_REGEX="^[A-Za-z0-9+_.-]+@(.+)$";
	private static final Pattern EMAIL_PATTERN=Pattern.compile(EMAIL_REGEX);
	

	@Override
	public CustomerDto createCustomer(CustomerDto customerDto) {
		
		validateEmail(customerDto.getEmail());
		Optional<Customer>existingCustomer=customerRepository.findByEmail(customerDto.getEmail());
		if(existingCustomer.isPresent()) {
			throw new ResourceAlreadyExistsException("Customer with email " + customerDto.getEmail() + " already exists.");
		}
		Customer customer=CustomerMapper.mapToCustomer(customerDto);
		Customer savedcustomer = customerRepository.save(customer);
		return CustomerMapper.mapToCustomerDto(savedcustomer);
		
	}
	
	private void validateEmail(String email) {
		if(!EMAIL_PATTERN.matcher(email).matches()) {
			throw new InvalidEmailException("Invalid email format:"+email);
		}
	}

	

}
