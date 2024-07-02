package com.electricity.bill.exceptions;

public class InvalidStartAndEndDate extends RuntimeException {
	
	public InvalidStartAndEndDate(String message) {
        super(message);
    }

}
