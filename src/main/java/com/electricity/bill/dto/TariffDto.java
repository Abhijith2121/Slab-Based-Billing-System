package com.electricity.bill.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.NotNull;

public class TariffDto {
	
	    private Long id;
	    @NotNull(message="Start date is required")
	    private LocalDate startDate;
	    
	    @NotNull(message="End date is required")
	    private LocalDate endDate;
	    
	    @NotNull(message="Rate per unit is required")
	    private Double ratePerUnit;
	    
	    @NotNull(message="Minimum units is required")
	    private Integer minUnits;
	    
	    @NotNull(message="Maximum units is required")
	    private Integer maxUnits;
	    
	    @NotNull(message="Number of days is required")
	    private Integer numberOfDays;
	    
	    private Long customerId;
	    
	    
	    
	   
		public TariffDto() {
			super();
		
		}
		public TariffDto(Long id, LocalDate startDate, LocalDate endDate, Double ratePerUnit, Integer minUnits,
				Integer maxUnits,Integer numberOfDays,Long customerId) {
			super();
			this.id = id;
			this.startDate = startDate;
			this.endDate = endDate;
			this.ratePerUnit = ratePerUnit;
			this.minUnits = minUnits;
			this.maxUnits = maxUnits;
			this.numberOfDays=numberOfDays;
			this.customerId=customerId;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public LocalDate getStartDate() {
			return startDate;
		}
		public void setStartDate(LocalDate startDate) {
			this.startDate = startDate;
		}
		public LocalDate getEndDate() {
			return endDate;
		}
		public void setEndDate(LocalDate endDate) {
			this.endDate = endDate;
		}
		public Double getRatePerUnit() {
			return ratePerUnit;
		}
		public void setRatePerUnit(Double ratePerUnit) {
			this.ratePerUnit = ratePerUnit;
		}
		public Integer getMinUnits() {
			return minUnits;
		}
		public void setMinUnits(Integer minUnits) {
			this.minUnits = minUnits;
		}
		public Integer getMaxUnits() {
			return maxUnits;
		}
		public void setMaxUnits(Integer maxUnits) {
			this.maxUnits = maxUnits;
		}
		

		public Integer getNumberOfDays() {
			return numberOfDays;
		}
		public void setNumberOfDays(Integer numberOfDays) {
			this.numberOfDays = numberOfDays;
		}
		
		 
		public Long getCustomerId() {
			return customerId;
		}
		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}
	    
	    
	

}
