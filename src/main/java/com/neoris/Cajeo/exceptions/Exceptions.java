package com.neoris.Cajeo.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.OK)
public class Exceptions extends Exception {
	
  	private static final long serialVersionUID = 1L;

	public Exceptions(String mensaje) {
        super(mensaje);
    }
}
