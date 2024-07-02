package com.electricity.bill.services;

import com.electricity.bill.dto.ReadingDto;
import com.electricity.bill.entity.Bill;
import com.electricity.bill.entity.Reading;

public interface BillService {
	
	Bill generateBill(Long customerId,ReadingDto reading);

}
