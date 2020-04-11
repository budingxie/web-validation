package com.py.webvalidation.handler;

import com.py.webvalidation.bo.Result;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 彭有
 * @date 2020/4/11
 */
@RestControllerAdvice
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleBindGetException(MethodArgumentNotValidException ex) {

        List<String> error = ex.getBindingResult().getFieldErrors().stream().
                map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());

        return new Result(false, 2001, "参数传入错误", error);
    }

    @ExceptionHandler(value = ValidationException.class)
    public Result handleBindException(ValidationException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());

        List<String> errors = new LinkedList<>();
        if (ex instanceof ConstraintViolationException) {
            ConstraintViolationException exs = (ConstraintViolationException) ex;
            Set<ConstraintViolation<?>> violationSet = exs.getConstraintViolations();
            for (ConstraintViolation<?> item : violationSet) {
                errors.add(item.getMessage());
            }
        }
        body.put("error", errors);
        return new Result(true, 2001, "提交的参数错误", body);
    }
}
