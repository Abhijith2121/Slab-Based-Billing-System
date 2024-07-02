package com.electricity.bill.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electricity.bill.dto.TariffDto;
import com.electricity.bill.entity.Customer;
import com.electricity.bill.entity.Tariff;
import com.electricity.bill.exceptions.CustomerNotFoundException;
import com.electricity.bill.exceptions.InvalidMaxUnitsException;
import com.electricity.bill.exceptions.InvalidStartAndEndDate;
import com.electricity.bill.exceptions.InvalidTariffException;
import com.electricity.bill.mapper.TariffMapper;
import com.electricity.bill.repository.CustomerRepository;
import com.electricity.bill.repository.TariffRepository;
import com.electricity.bill.services.TariffService;


@Service
public class TariffServiceImpl implements TariffService {
	
	@Autowired
	private TariffRepository tariffRepository;
	
	 @Autowired
     private CustomerRepository customerRepository;

	@Override
	public TariffDto createTariff(TariffDto tariffDto) {
		 if (tariffDto.getRatePerUnit() < 0) {
	            throw new InvalidTariffException("Rate per unit cannot be negative");
	        }else if(tariffDto.getMinUnits()<0 || tariffDto.getMaxUnits()<0 ) {
	        	throw new InvalidTariffException(" Min or Max unit cannot be negative");
	        }
	        else if(tariffDto.getMaxUnits() < tariffDto.getMinUnits()) {
	        	throw new InvalidMaxUnitsException("Maximum unitis cannot be lesser than minimumunits");
	        }
		 
	      if (tariffDto.getStartDate().isAfter(tariffDto.getEndDate())) {
	            throw new InvalidStartAndEndDate("Start date cannot be lesser than end date");
	        }
	      
	     

	      
	      Customer customer = customerRepository.findById(tariffDto.getCustomerId())
	                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
		Tariff tariff = TariffMapper.mapToTariff(tariffDto);
		
		tariff.setCustomer(customer);
		Tariff savedTariff=tariffRepository.save(tariff);
		return TariffMapper.mapToTariffDto(savedTariff);
		
		
		
	}

}
