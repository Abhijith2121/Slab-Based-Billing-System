package com.electricity.bill.mapper;

import com.electricity.bill.dto.ReadingDto;
import com.electricity.bill.entity.Reading;

public class ReadingMapper {
	
	 public static ReadingDto mapToReadingDto(Reading reading) {
		 
	        ReadingDto readingDto = new ReadingDto();
	        
	        readingDto.setId(reading.getId());
	        readingDto.setCustomerId(reading.getCustomer().getId());
	        readingDto.setReadingDate(reading.getReadingDate());
	        readingDto.setUnits(reading.getUnits());
	        
	        return readingDto;
	    }

	    public static Reading mapToReading(ReadingDto readingDto) {
	    	
	        Reading reading = new Reading();
	        
	        reading.setId(readingDto.getId());
	        reading.setReadingDate(readingDto.getReadingDate());
	        reading.setUnits(readingDto.getUnits());
	        
	        return reading;
	    }

}
