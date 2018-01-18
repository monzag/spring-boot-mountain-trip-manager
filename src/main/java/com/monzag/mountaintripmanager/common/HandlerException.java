package com.monzag.mountaintripmanager.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    private AppLogger logger;

    public HandlerException(AppLogger logger) {
        this.logger = logger;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotExistException.class)
    public String handleException(ObjectNotExistException e) {
        logger.error("User error: object with provide id not exist or is archived");
        return e.getMessage();
    }
}
