package com.electricity.bill.dto;

import java.time.LocalDate;

public class BillDto {
	
	    private Long id;
	    private Long customerId;
	    private LocalDate billingDate;
	    private Double amount;
	    
		public BillDto(Long id, Long customerId, LocalDate billingDate, Double amount) {
			super();
			this.id = id;
			this.customerId = customerId;
			this.billingDate = billingDate;
			this.amount = amount;
		}
		
		
		public BillDto() {
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
		public LocalDate getBillingDate() {
			return billingDate;
		}
		public void setBillingDate(LocalDate billingDate) {
			this.billingDate = billingDate;
		}
		public Double getAmount() {
			return amount;
		}
		public void setAmount(Double amount) {
			this.amount = amount;
		}
	    
	    

}
