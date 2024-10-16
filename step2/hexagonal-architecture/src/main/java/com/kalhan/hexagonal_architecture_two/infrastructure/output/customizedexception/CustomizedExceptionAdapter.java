package com.kalhan.hexagonal_architecture_two.infrastructure.output.customizedexception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.kalhan.hexagonal_architecture_two.domain.exception.ProductNotFound;
import com.kalhan.hexagonal_architecture_two.infrastructure.output.customizedexception.data.response.ExceptionResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedExceptionAdapter extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(final Exception ex, final WebRequest request) {
        final ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(),
                List.of(request.getDescription(false)));

        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ProductNotFound.class)
    public final ResponseEntity<Object> handleUserNotFoundException(final ProductNotFound ex, final WebRequest request) {
        final ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(),
                List.of(request.getDescription(false)));

        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }


}