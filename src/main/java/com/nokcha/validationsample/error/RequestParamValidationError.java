package com.nokcha.validationsample.error;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RequestParamValidationError {
    String message;
    List details;

    @Data
    @AllArgsConstructor
    public static class ViolationDetail {
        String name;
        String defaultMessage;
        Object rejectedValue;
    }
}

