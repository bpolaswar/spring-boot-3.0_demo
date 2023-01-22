package com.springbootlatest.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler{

	private ProblemDetail problemDetail;

	@org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
	public ProblemDetail handleRuntimeException(RuntimeException runtimeException){
		return problemDetail.forStatusAndDetail(HttpStatusCode.valueOf(400),runtimeException.getMessage());
	}
}
