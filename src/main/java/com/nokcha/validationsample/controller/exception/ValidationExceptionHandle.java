package com.nokcha.validationsample.controller.exception;

import com.nokcha.validationsample.controller.RequestParamController;
import com.nokcha.validationsample.error.RequestParamValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@ControllerAdvice(assignableTypes = { RequestParamController.class} )
public class ValidationExceptionHandle extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ConstraintViolationException.class})
    protected ResponseEntity handleConstraintViolation(ConstraintViolationException exception, WebRequest request) {
        var details = exception.getConstraintViolations()
                .parallelStream()
                .map(violation ->
                    new RequestParamValidationError.ViolationDetail(
                            violation.getPropertyPath().toString(),
                            violation.getMessage(),
                            violation.getInvalidValue()
                    )
                ).collect(Collectors.toList());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new RequestParamValidationError(exception.getLocalizedMessage(), details));
    }
}


