package com.spi.exception;

public class SupplierAlreadyExistsException extends RuntimeException {
	private String message;

	public SupplierAlreadyExistsException() {

	}

	public SupplierAlreadyExistsException(String msg) {

		super(msg);
		this.message = msg;

	}
}
