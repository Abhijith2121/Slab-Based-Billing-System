package com.electricity.bill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electricity.bill.dto.BillDto;
import com.electricity.bill.dto.ReadingDto;
import com.electricity.bill.entity.Bill;
import com.electricity.bill.impl.BillServiceImpl;
import com.electricity.bill.impl.ReadingServiceImpl;
import com.electricity.bill.mapper.BillMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/reading")
@Validated
public class ReadingController {

	@Autowired
	private ReadingServiceImpl readingServiceImpl;
	
	@Autowired
	private BillServiceImpl billServiceImpl;
	
	@PostMapping
	public ResponseEntity<ReadingDto>createReading(@Valid @RequestBody ReadingDto readingDto){
		ReadingDto savedReadingDto=readingServiceImpl.createReading(readingDto);
		return new ResponseEntity<>(savedReadingDto,HttpStatus.ACCEPTED);
		
	}
	
	
	 @PostMapping("/generateBill")
		 public ResponseEntity<BillDto> genrateBill(@Valid @RequestBody ReadingDto readingDto){
			 Bill bill=billServiceImpl.generateBill(readingDto.getCustomerId(), readingDto);
			 BillDto billDto=BillMapper.mapToBillDto(bill);
			 return new ResponseEntity<>(billDto,HttpStatus.CREATED);
		 }
	 }
	

	
