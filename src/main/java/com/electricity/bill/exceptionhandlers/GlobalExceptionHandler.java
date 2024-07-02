package com.electricity.bill.exceptionhandlers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.electricity.bill.exceptions.CustomerNotFoundException;
import com.electricity.bill.exceptions.DuplicateReadingException;
import com.electricity.bill.exceptions.InvalidEmailException;
import com.electricity.bill.exceptions.InvalidMaxUnitsException;
import com.electricity.bill.exceptions.InvalidStartAndEndDate;
import com.electricity.bill.exceptions.InvalidTariffException;
import com.electricity.bill.exceptions.ResourceAlreadyExistsException;
import com.electricity.bill.exceptions.TariffNotFoundException;


@RestControllerAdvice
public class GlobalExceptionHandler {

    
    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceAlreadyExistsException ex) {
        ErrorResponse errorResponse = new ErrorResponse("ERR_NOT_FOUND", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    
    
    @ExceptionHandler(InvalidTariffException.class)
    public ResponseEntity<ErrorResponse> handleInvalidtariffException(InvalidTariffException ex) {
        ErrorResponse errorResponse = new ErrorResponse("NEGATIVE_VALUE", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(InvalidStartAndEndDate.class)
    public ResponseEntity<ErrorResponse> handleInvalidStartAndEndDate(InvalidStartAndEndDate ex) {
        ErrorResponse errorResponse = new ErrorResponse("DATE_RANGE_ERROR", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(InvalidMaxUnitsException.class)
    public ResponseEntity<ErrorResponse> handleInvalidMaxUnitsException(InvalidMaxUnitsException ex) {
        ErrorResponse errorResponse = new ErrorResponse("INVALID_MAXUNITS_VALUE", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCustomerrNotFound(CustomerNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse("CUSTOMER_NOT_FOUND", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<ErrorResponse> handleInvalidEmailException(InvalidEmailException ex) {
        ErrorResponse errorResponse = new ErrorResponse("INVALID_EMAIL", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(DuplicateReadingException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateReadingException(DuplicateReadingException ex) {
        ErrorResponse errorResponse = new ErrorResponse("DUPLICATE_READING", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(TariffNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleTariffNotFoundException(TariffNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse("TARIFF_NOTFOUND", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse>handleValidationException(MethodArgumentNotValidException ex){
    	FieldError error=ex.getBindingResult().getFieldErrors().get(0);
    	String errorMessage=error.getDefaultMessage();
    	String errorCode=getErrorCode(error.getField());
    	ErrorResponse errorResponse = new ErrorResponse(errorCode,errorMessage);
    	return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
    	
    }
    
    private String getErrorCode(String field) {
        switch (field) {
            case "firstName":
                return "FIRST_NAME_REQUIRED";
            case "lastName":
                return "LAST_NAME_REQUIRED";
            case "email":
                return "EMAIL_REQUIRED";
            case "startDate":
                return "START_DATE_REQUIRED";
            case "endDate":
                return "END_DATE_REQUIRED";
            case "ratePerUnit":
                return "RATE_PER_UNIT_REQUIRED";
            case "minUnits":
                return "MIN_UNITS_REQUIRED";
            case "maxUnits":
                return "MAX_UNITS_REQUIRED";    
            case "customerId":
                return "CUSTOMER_ID_REQUIRED";
            case "readingDate":
                return "READING_DATE_REQUIRED";
            case "units":
                return "UNITS_REQUIRED";
            default:
                return "VALIDATION_ERROR";
        }
    }

    
    public static class ErrorResponse {
        private String errorCode;
        private String message;

      
        public ErrorResponse(String errorCode, String message) {
            this.errorCode = errorCode;
            this.message = message;
        }

       
        public String getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}

