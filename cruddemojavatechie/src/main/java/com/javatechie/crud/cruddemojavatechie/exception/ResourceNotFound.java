package com.javatechie.crud.cruddemojavatechie.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceNotFound extends RuntimeException{
	
	public ResourceNotFound(String message)
	{
		super(message);
	}

}
