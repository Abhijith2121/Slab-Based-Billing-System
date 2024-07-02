package com.electricity.bill.services;



import com.electricity.bill.dto.CustomerDto;
import com.electricity.bill.entity.Customer;



public interface CustomerService {
	
 CustomerDto createCustomer(CustomerDto customer);

 
}
