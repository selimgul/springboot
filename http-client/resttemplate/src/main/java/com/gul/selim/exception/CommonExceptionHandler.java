package com.gul.selim.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleAllExceptions(Exception ex, WebRequest request) {

		Map<String, String> excDetails = new HashMap<String, String>();
		excDetails.put("Status", "CommonExceptionHandler got this exception.");
		excDetails.put("Detail", ex.getLocalizedMessage());		
		return new ResponseEntity<>(excDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
