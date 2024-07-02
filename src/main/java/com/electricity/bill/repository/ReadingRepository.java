package com.electricity.bill.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electricity.bill.entity.Customer;
import com.electricity.bill.entity.Reading;

public interface ReadingRepository extends JpaRepository<Reading,Long> {
	
	 Reading findTopByCustomerOrderByReadingDateDesc(Customer customer);
	 boolean existsByCustomerAndReadingDateBetween(Customer customer,LocalDate startDate,LocalDate endDate);

}
