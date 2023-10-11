package com.example.framework.common;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

//校验全局异常
@RestControllerAdvice
public class GlobalExceptionHandler {

    //捕获所有异常
    @ExceptionHandler(Exception.class)
    public Result<String> exceptionHandler(Exception e) {
        if (e instanceof BindException) {
            BindException bindException = (BindException) e;
            return Result.fail(bindException.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        } else {
            return Result.error(e.getMessage());
        }
    }

    //捕获校验时候的异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result<String> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<String> list = new ArrayList<>();

        for (ObjectError objectError : e.getBindingResult().getAllErrors()) {
            if (objectError instanceof FieldError) {
                FieldError fieldError = (FieldError) objectError;
                list.add(fieldError.getDefaultMessage());
            } else {
                list.add(objectError.getDefaultMessage());
            }
        }
        return Result.fail(list);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handleConstraintViolationException(ConstraintViolationException ex) {
        return Result.fail(ex.getMessage());
    }
}