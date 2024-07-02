package com.electricity.bill.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electricity.bill.dto.ReadingDto;
import com.electricity.bill.entity.Bill;
import com.electricity.bill.entity.Customer;
import com.electricity.bill.entity.Reading;
import com.electricity.bill.entity.Tariff;
import com.electricity.bill.exceptions.CustomerNotFoundException;
import com.electricity.bill.exceptions.TariffNotFoundException;
import com.electricity.bill.mapper.ReadingMapper;
import com.electricity.bill.repository.BillRepository;
import com.electricity.bill.repository.CustomerRepository;
import com.electricity.bill.repository.ReadingRepository;
import com.electricity.bill.repository.TariffRepository;
import com.electricity.bill.services.BillService;


@Service
public class BillServiceImpl implements BillService {
	
	@Autowired
	private CustomerRepository customerRepositry;

	
	@Autowired
	private TariffRepository tariffRepository;
	
	@Autowired
	private BillRepository billRepository;
	
	@Autowired
	private ReadingServiceImpl readingServiceImpl;

	@Override
	public Bill generateBill(Long customerId, ReadingDto readingDto) {
		Customer customer = customerRepositry.findById(readingDto.getCustomerId()).
				            orElseThrow(()->new CustomerNotFoundException("Customer is not found"));
		
	Reading previousReading=readingServiceImpl.getLatestReading(customerId);
	int consumption = readingDto.getUnits()-(previousReading!=null ? previousReading.getUnits() : 0);
	int numberOfDays;
	if (previousReading != null) {
	    numberOfDays = (int) ChronoUnit.DAYS.between(previousReading.getReadingDate(), readingDto.getReadingDate());
	} else {
	    // Fetch tariff based on customer ID and get the number of days from the tariff
	    Tariff tariff = tariffRepository.findByCustomerId(readingDto.getCustomerId());
	    if (tariff == null) {
	        throw new TariffNotFoundException("Tariff not found for customer");
	    }else {
	    	 numberOfDays = tariff.getNumberOfDays();
	    }
	   
	}

	System.out.println("Number of days"+numberOfDays);
	
	double totalAmount = calculateBillAmount(customer.getId(),consumption,readingDto.getReadingDate(),numberOfDays);
	Bill bill= new Bill();
	bill.setCustomer(customer);
	bill.setAmount(totalAmount);
	bill.setBillingDate(LocalDate.now());
	
	return billRepository.save(bill);
		
		

	}
	
	
	
	private double calculateBillAmount(Long customerId, int consumption, LocalDate readingDate, int numberOfDays) {
		
		
	   double totalAmount=0;
        Tariff tariff = tariffRepository.findByCustomerId(customerId);
        if (tariff == null) {
	        throw new TariffNotFoundException("Tariff not found for customer");
        }
        else {
        	 double dailyRate = (tariff.getRatePerUnit() * (tariff.getMaxUnits() - tariff.getMinUnits())) / tariff.getNumberOfDays();
             totalAmount = dailyRate * numberOfDays;
        }
                

       

        return totalAmount;
    }
	

}
