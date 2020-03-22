package br.com.devdojo.springbootessentials.createdframework.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.devdojo.springbootessentials.createdframework.error.ResourceNotFoundDetails;
import br.com.devdojo.springbootessentials.createdframework.error.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException nfnException){
		ResourceNotFoundDetails respDetail = ResourceNotFoundDetails.builder().withTitle("Resource not found").withTime(new Date().getTime())
		.withStatus(HttpStatus.NOT_FOUND.value()).withDeveloperMessege(nfnException.getClass().getName())
		.withDetails(nfnException.getMessage()).build();
		return new ResponseEntity<>(respDetail, HttpStatus.NOT_FOUND);
	}
}
