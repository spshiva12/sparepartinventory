package com.spi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SparepartsNotfoundException extends Exception {

	public SparepartsNotfoundException() {

	}

	public SparepartsNotfoundException(String message) {
		super(message);
	}

}
