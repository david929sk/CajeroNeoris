package com.neoris.Cajeo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class ExceptionHandler {
	
    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(Exceptions.class)
    public ResponseEntity<String> manejarMiExcepcion(Exceptions ex) {
        return new ResponseEntity<>(ex.toString(), HttpStatus.OK);
    }
}
