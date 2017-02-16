package com.ddook.ddak.common.handler;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandlerAdvice {
	
	@ExceptionHandler(value={ SQLException.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	protected ErrorMessage testException(SQLException ex, WebRequest req) {
		ErrorMessage em = new ErrorMessage();
		em.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		em.setMessage(ex.getMessage());

		return em;
	}
	
}
