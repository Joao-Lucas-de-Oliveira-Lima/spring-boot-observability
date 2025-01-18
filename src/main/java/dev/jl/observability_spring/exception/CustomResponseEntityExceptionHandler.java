package dev.jl.observability_spring.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.Arrays;

@ControllerAdvice
@RestController
@Slf4j
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handlerException(WebRequest webRequest, Exception e){
        log.error(e.getMessage(), e);
        ExceptionDto response = ExceptionDto.builder()
                .detail(e.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .timestamp(Instant.now())
                .title(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .instance(webRequest.getDescription(false))
                .build();

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDto> handlerBadRequestException(WebRequest webRequest, Exception e){

        log.warn(e.getMessage());

        ExceptionDto response = ExceptionDto.builder()
                .detail(e.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .timestamp(Instant.now())
                .title(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .instance(webRequest.getDescription(false))
                .build();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }
}
