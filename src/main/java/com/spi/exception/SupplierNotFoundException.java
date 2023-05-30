package com.spi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SupplierNotFoundException extends RuntimeException{
	
	public SupplierNotFoundException() {

	}

	public SupplierNotFoundException(String message) {
		
		super(message);
	}

}
