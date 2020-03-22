package br.com.devdojo.springbootessentials.createdframework.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Damiao Ferreira
 * @since 15/03/2020
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 804556355500020989L;
	
	public ResourceNotFoundException(String message) {
		super(message);
	}

}
