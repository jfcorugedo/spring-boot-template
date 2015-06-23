package es.juan.test.errorhandling.global;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.juan.test.exception.NotFoundException;

@ControllerAdvice
@RestController
public class AppWideExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleNotFoundError(HttpServletRequest request, NotFoundException exception) {
		Map<String, Object> errorMessage = new LinkedHashMap<String, Object>();
		errorMessage.put("timestamp", new Date());
		errorMessage.put("path", request.getRequestURI());
		HttpStatus statusCode = AnnotationUtils.findAnnotation(exception.getClass(), ResponseStatus.class).value();
		errorMessage.put("statusCode", statusCode);
		
		return new ResponseEntity<Map<String,Object>>(errorMessage, statusCode); 
	}
}
