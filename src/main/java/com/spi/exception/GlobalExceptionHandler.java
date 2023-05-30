package com.spi.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

//	@ExceptionHandler(SalesNotFoundException.class)
//	public final ResponseEntity<Object> handleException(Exception ex, WebRequest req) {
//
//		ExceptionResponse exRes = new ExceptionResponse(ex.getMessage(), req.getDescription(false), new Date());
//
//		return new ResponseEntity(exRes, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//	
//
//	@ExceptionHandler(SparepartsNotfoundException.class)
//	public final ResponseEntity<Object> handleSparepartsRecordNotfoundException(Exception ex, WebRequest req) {
//
//		ExceptionResponse exRes = new ExceptionResponse(ex.getMessage(), req.getDescription(false), new Date());
//
//		return new ResponseEntity(exRes, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//
//	@ExceptionHandler(SupplierNotFoundException.class)
//	public final ResponseEntity<Object> handleSupplierNotfoundException(Exception ex, WebRequest req) {
//
//		ExceptionResponse exRes = new ExceptionResponse(ex.getMessage(), req.getDescription(false), new Date());
//
//		return new ResponseEntity(exRes, HttpStatus.INTERNAL_SERVER_ERROR);
//	}

	@ExceptionHandler(SalesNotFoundException.class)
	public final ResponseEntity<Object> handleSalesNotfoundException(Exception ex, WebRequest req) {
		// Creating Exception Response Structure

		ExceptionResponse exRes = new ExceptionResponse(ex.getMessage(), req.getDescription(false), new Date());

		return new ResponseEntity(exRes, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(SparepartsNotfoundException.class)
	public final ResponseEntity<Object> handleSparepartsNotfoundException(Exception ex, WebRequest req) {
		// Creating Exception Response Structure

		ExceptionResponse exRes = new ExceptionResponse(ex.getMessage(), req.getDescription(false), new Date());

		return new ResponseEntity(exRes, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(SupplierNotFoundException.class)
	public final ResponseEntity<Object> handleResourceNotFoundException(Exception ex, WebRequest req) {
		// Creating Exception Response Structure

		ExceptionResponse exRes = new ExceptionResponse(ex.getMessage(), req.getDescription(false), new Date());

		return new ResponseEntity(exRes, HttpStatus.NOT_FOUND);
	}

}