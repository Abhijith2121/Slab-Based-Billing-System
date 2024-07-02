package com.electricity.bill.mapper;

import com.electricity.bill.dto.BillDto;
import com.electricity.bill.entity.Bill;

public class BillMapper {
	
	public static BillDto mapToBillDto(Bill bill) {
		
        BillDto billDto = new BillDto();
        
        billDto.setId(bill.getId());
        billDto.setCustomerId(bill.getCustomer().getId());
        billDto.setBillingDate(bill.getBillingDate());
        billDto.setAmount(bill.getAmount());
        
        return billDto;
    }

    public static Bill mapToBill(BillDto billDto) {
    	
        Bill bill = new Bill();
        
        bill.setId(billDto.getId());
        // You need to set the customer object separately as it involves fetching it from the database
        bill.setBillingDate(billDto.getBillingDate());
        bill.setAmount(billDto.getAmount());
        
        return bill;
    }
}
