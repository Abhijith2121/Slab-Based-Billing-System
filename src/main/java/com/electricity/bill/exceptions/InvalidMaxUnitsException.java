package com.electricity.bill.exceptions;

public class InvalidMaxUnitsException extends RuntimeException {
	public InvalidMaxUnitsException(String message) {
        super(message);
    }
}
