package com.electricity.bill.exceptions;

public class TariffNotFoundException extends RuntimeException {
	public TariffNotFoundException(String message) {
        super(message);
    
}
}
