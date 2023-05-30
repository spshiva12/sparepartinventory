package com.spi.exception;

import java.util.Date;

import lombok.Data;

@Data
public class ExceptionResponse {

	private String message;
	private String details;
	private Date timestamp;

	public ExceptionResponse(String message, String details, Date timestamp) {
		super();
		this.message = message;
		this.details = details;
		this.timestamp = timestamp;
	}
}