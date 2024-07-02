package com.electricity.bill.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public class ReadingDto {
	
	    private Long id;
	    
	    @NotNull(message = "Customer ID is required")
	    private Long customerId;
	    
	    @NotNull(message = "Reading date is required")
	    private LocalDate readingDate;
	    
	    @NotNull(message = "Units is required")
	    private Integer units;
	    
		public ReadingDto(Long id, Long customerId, LocalDate readingDate, Integer units) {
			super();
			this.id = id;
			this.customerId = customerId;
			this.readingDate = readingDate;
			this.units = units;
		}
		
		
		public ReadingDto() {
			super();
			
		}


		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Long getCustomerId() {
			return customerId;
		}
		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}
		public LocalDate getReadingDate() {
			return readingDate;
		}
		public void setReadingDate(LocalDate readingDate) {
			this.readingDate = readingDate;
		}
		public Integer getUnits() {
			return units;
		}
		public void setUnits(Integer units) {
			this.units = units;
		}
	    
	    
	    

}
