package com.electricity.bill.services;

import com.electricity.bill.dto.ReadingDto;
import com.electricity.bill.entity.Reading;

public interface ReadingService {
	
	ReadingDto createReading(ReadingDto reading);
    Reading getLatestReading(Long customerId);

}
