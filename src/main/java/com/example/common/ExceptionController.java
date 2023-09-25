package com.example.common;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice // RestController를 위한 조언을 해주는 어노테이션
public class ExceptionController {
    @ExceptionHandler(NoSuchElementException.class) // 어떤 Exception을 Handling 할지 결정
    public ResponseEntity<ExceptionResponse> handleException(NoSuchElementException e) {
        ExceptionResponse errorResponse = new ExceptionResponse("데이터좀 잘 좀 빼갑시다~!", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

}
