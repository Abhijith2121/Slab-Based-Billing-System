package com.electricity.bill.impl;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electricity.bill.dto.ReadingDto;
import com.electricity.bill.entity.Customer;
import com.electricity.bill.entity.Reading;
import com.electricity.bill.exceptions.CustomerNotFoundException;
import com.electricity.bill.exceptions.DuplicateReadingException;
import com.electricity.bill.exceptions.InvalidTariffException;
import com.electricity.bill.mapper.ReadingMapper;
import com.electricity.bill.repository.CustomerRepository;
import com.electricity.bill.repository.ReadingRepository;
import com.electricity.bill.services.ReadingService;


@Service
public class ReadingServiceImpl implements ReadingService {
	
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ReadingRepository readingRepository;
	

	@Override
	public ReadingDto createReading(ReadingDto readingDto) {
		Optional<Customer>optionalCustomer=customerRepository.findById(readingDto.getCustomerId());
		
		if(readingDto.getUnits()<0) {
			throw new InvalidTariffException("Read units cannot be negative");
		}
		 if (optionalCustomer.isEmpty()) {
	            throw new CustomerNotFoundException("Customer not found with ID: " + readingDto.getCustomerId());
	        }
		 
		
		  Customer customer = optionalCustomer.get();
		  LocalDate readingMonth=readingDto.getReadingDate().withDayOfMonth(1);
		  boolean readingExists=readingRepository.existsByCustomerAndReadingDateBetween(customer,readingMonth,readingMonth.plusMonths(1).minusDays(1));
		  if(readingExists) {
			  throw new DuplicateReadingException("Reading already exists for customer with ID: " + readingDto.getCustomerId()
              + " in month: " + readingMonth.getMonth() + " " + readingMonth.getYear());
  }
		  
		  
	        Reading reading = new Reading();
	        reading.setCustomer(customer);
	        reading.setReadingDate(readingDto.getReadingDate());
	        reading.setUnits(readingDto.getUnits());

	       
	        Reading savedReading = readingRepository.save(reading);
	        return ReadingMapper.mapToReadingDto(savedReading);
		
		
	}

	

	@Override
	public Reading getLatestReading(Long customerId) {
		 Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));
	      return readingRepository.findTopByCustomerOrderByReadingDateDesc(customer);
		
	}


	

}
