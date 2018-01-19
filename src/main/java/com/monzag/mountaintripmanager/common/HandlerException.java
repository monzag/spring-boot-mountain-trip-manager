package com.monzag.mountaintripmanager.common;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @ExceptionHandler(ArchivedObjectException.class)
    public ResponseEntity<String> handleException(ArchivedObjectException e) {
        logger.error("User error: object with provide id is archived");
        return getResponse(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ObjectNotExistException.class)
    public ResponseEntity<String> handleException(ObjectNotExistException e) {
        logger.error("User error: object with provide id not exist");
        return getResponse(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<String> getResponse(String message, HttpStatus status) {
        JSONObject response = new JSONObject();
        try {
            response.put("status", status.toString());
            response.put("message", message);
        } catch (JSONException e) {
            logger.error("Program error: json response can't be create");
        }
        return new ResponseEntity<>(response.toString(), status);
    }
}
