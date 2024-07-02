package com.electricity.bill.mapper;

import com.electricity.bill.dto.CustomerDto;
import com.electricity.bill.entity.Customer;

public class CustomerMapper {
	
	 public static CustomerDto mapToCustomerDto(Customer customer) {
		 
	        CustomerDto customerDto = new CustomerDto();
	        
	        customerDto.setId(customer.getId());
	        customerDto.setFirstName(customer.getFirstName());
	        customerDto.setLastName(customer.getLastName());
	        customerDto.setEmail(customer.getEmail());
	        
	        return customerDto;
	    }

	    public static Customer mapToCustomer(CustomerDto customerDto) {
	    	
	        Customer customer = new Customer();
	        
	        customer.setId(customerDto.getId());
	        customer.setFirstName(customerDto.getFirstName());
	        customer.setLastName(customerDto.getLastName());
	        customer.setEmail(customerDto.getEmail());
	        
	        return customer;
	    }
}
