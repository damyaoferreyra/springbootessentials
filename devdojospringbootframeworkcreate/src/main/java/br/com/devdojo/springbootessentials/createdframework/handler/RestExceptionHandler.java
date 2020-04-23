package br.com.devdojo.springbootessentials.createdframework.handler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.devdojo.springbootessentials.createdframework.error.ErrorDetail;
import br.com.devdojo.springbootessentials.createdframework.error.ResourceNotFoundDetails;
import br.com.devdojo.springbootessentials.createdframework.error.ResourceNotFoundException;
import br.com.devdojo.springbootessentials.createdframework.error.ValidationErrorDetails;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException nfnException){
		ResourceNotFoundDetails respDetail = ResourceNotFoundDetails.builder().withTitle("Resource not found").withTime(new Date().getTime())
		.withStatus(HttpStatus.NOT_FOUND.value()).withDeveloperMessege(nfnException.getClass().getName())
		.withDetails(nfnException.getMessage()).build();
		return new ResponseEntity<>(respDetail, HttpStatus.NOT_FOUND);
	}
	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException manvException, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<FieldError> fieldErros = manvException.getBindingResult().getFieldErrors();
		
		// iterar na lista de error
		String fields = fieldErros.stream().map(FieldError::getField).collect(Collectors.joining(","));
		String fieldMessage =  fieldErros.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));
		
		ValidationErrorDetails respDetail = ValidationErrorDetails.builder()
				.withTitle("Field Validation Error").withTime(new Date().getTime())
				.withStatus(HttpStatus.BAD_REQUEST.value()).withDeveloperMessege(manvException.getClass().getName())
				.withDetails("Field Validation Error")
				.withField(fields).withFieldMessage(fieldMessage)
				.build();
		return new ResponseEntity<>(respDetail, HttpStatus.BAD_REQUEST);
	}
	
	@Override
	public ResponseEntity<Object> handleExceptionInternal(
			Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ErrorDetail respDetail = ErrorDetail.newBuilder()
				.withTime(new Date().getTime())
				.withStatus(status.value())
				.withTitle("Internal Exception")
				.withDetails(ex.getClass().getName())
				.withDeveloperMessege(ex.getMessage())
				.build();
		return new ResponseEntity<>(respDetail, HttpStatus.BAD_REQUEST);
		
	}
	
	
}
