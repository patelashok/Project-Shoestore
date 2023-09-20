package com.api.ecommerce.shoes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(value= AdminException.class)
	public ResponseEntity<Object> exception(AdminException exception) {
		return new ResponseEntity<>("User already Exists", HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value= AdminUserNotFoundException.class)
	public ResponseEntity<Object> exception(AdminUserNotFoundException exception) {
		return new ResponseEntity<>("User Not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value= ProductException.class)
	public ResponseEntity<Object> exception(ProductException exception) {
		return new ResponseEntity<>("Product already exist", HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value= LoginException.class)
	public ResponseEntity<Object> exception(LoginException exception) {
		return new ResponseEntity<>("Bad Credentials Try Again", HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(value= UserException.class)
	public ResponseEntity<Object> exception(UserException exception) {
		return new ResponseEntity<>("You are already registered", HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value= NoUserFoundException.class)
	public ResponseEntity<Object> exception(NoUserFoundException exception) {
		return new ResponseEntity<>("you are not registered user", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value= ProductNotFoundException.class)
	public ResponseEntity<Object> exception(ProductNotFoundException exception) {
		return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value= PurchaseReportException.class)
	public ResponseEntity<Object> exception(PurchaseReportException exception) {
		return new ResponseEntity<>("Purchase Report already exists", HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value= PurchaseReportNotFoundException.class)
	public ResponseEntity<Object> exception(PurchaseReportNotFoundException exception) {
		return new ResponseEntity<>("Purchase Report doesn't exist", HttpStatus.NOT_FOUND);
	}
}

