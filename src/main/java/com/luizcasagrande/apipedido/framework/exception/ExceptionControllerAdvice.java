package com.luizcasagrande.apipedido.framework.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.NoResultException;
import java.sql.SQLException;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ResponseBody
    @ExceptionHandler(NoResultException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleNoResultException(Exception ex, WebRequest request) {
        return new Error(ex.getMessage(), request.getDescription(false));
    }

    @ResponseBody
    @ExceptionHandler(SQLException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleSQLException(Exception ex, WebRequest request) {
        return new Error(ExceptionUtils.getRootCauseMessage(ex), request.getDescription(false));
    }

    @ResponseBody
    @ExceptionHandler(ExpectedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleExpectedException(Exception ex, WebRequest request) {
        return new Error(ex.getMessage(), request.getDescription(false));
    }
}
