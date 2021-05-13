package com.bookapp.exceptions;

import java.time.LocalDateTime;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bookapp.model.ApiErrors;
 
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		String reason = status.getReasonPhrase();
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), status.value(), reason, message);
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		String reason = status.getReasonPhrase();
		HttpHeaders header = new HttpHeaders();
		header.add("error", "Media type not supported");
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), status.value(), reason, message);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		String reason = status.getReasonPhrase();
		HttpHeaders header = new HttpHeaders();
		header.add("error", "Missing Path Variable");
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), status.value(), reason, message);
		return ResponseEntity.status(status).headers(headers).body(errors);

	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		String reason = status.getReasonPhrase();
		HttpHeaders header = new HttpHeaders();
		header.add("error", "Missing RequestParam");
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), status.value(), reason, message);
		return ResponseEntity.status(status).headers(headers).body(errors);

	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		String reason = status.getReasonPhrase();
		HttpHeaders header = new HttpHeaders();
		header.add("error", "Input mismatch");
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), status.value(), reason, message);
		return ResponseEntity.status(status).headers(headers).body(errors);

	}

	@ExceptionHandler(AuthorNotFoundException.class)
	protected ResponseEntity<Object> handleStudentNotFoundException(AuthorNotFoundException ex) {
		String message = ex.getMessage();
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String reason = HttpStatus.BAD_REQUEST.getReasonPhrase();
		HttpHeaders header = new HttpHeaders();
		header.add("error", "Author not found");
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), status.value(), reason, message);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(header).body(errors);
	}

	@ExceptionHandler(IdNotFoundException.class)
	protected ResponseEntity<Object> handleIDNotFoundException(IdNotFoundException ex) {
		String message = ex.getMessage();
		HttpStatus status = HttpStatus.FAILED_DEPENDENCY;
		String reason = HttpStatus.FAILED_DEPENDENCY.getReasonPhrase();
		HttpHeaders header = new HttpHeaders();
		header.add("error", "Id not found");
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), status.value(), reason, message);
		return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).headers(header).body(errors);

	}

	@ExceptionHandler(BookNotFoundException.class)
	protected ResponseEntity<Object> handleBookNotFoundException(BookNotFoundException ex) {
		String message = ex.getMessage();
		HttpStatus status = HttpStatus.FAILED_DEPENDENCY;
		String reason = HttpStatus.FAILED_DEPENDENCY.getReasonPhrase();
		HttpHeaders header = new HttpHeaders();
		header.add("error", "City not found");
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), status.value(), reason, message);
		return ResponseEntity.status(status).headers(header).body(errors);

	}
	@ExceptionHandler(CategoryNotFoundException.class)
	protected ResponseEntity<Object> handleCategoryNotFoundException(CategoryNotFoundException ex) {
		String message = ex.getMessage();
		HttpStatus status = HttpStatus.FAILED_DEPENDENCY;
		String reason = HttpStatus.FAILED_DEPENDENCY.getReasonPhrase();
		HttpHeaders header = new HttpHeaders();
		header.add("error", "City not found");
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), status.value(), reason, message);
		return ResponseEntity.status(status).headers(header).body(errors);

	}

}
