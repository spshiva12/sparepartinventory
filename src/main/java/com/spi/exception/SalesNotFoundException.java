package com.spi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SalesNotFoundException extends RuntimeException {

	public SalesNotFoundException() {
		
	}

	public SalesNotFoundException(String message) {
		super(message);
	}

}