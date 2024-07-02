package com.electricity.bill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electricity.bill.dto.TariffDto;
import com.electricity.bill.entity.Tariff;
import com.electricity.bill.impl.TariffServiceImpl;
import com.electricity.bill.mapper.TariffMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tariffs")
@Validated
public class TariffController {

	@Autowired
	private TariffServiceImpl tariffServiceImpl;
	
	
	@PostMapping
	public ResponseEntity<TariffDto>createTarriff(@Valid @RequestBody TariffDto tariffDto){
		TariffDto savedTariffDto = tariffServiceImpl.createTariff(tariffDto); 
		return new ResponseEntity<>(savedTariffDto,HttpStatus.CREATED);
		
	}
	
	
	
}
