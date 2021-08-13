package com.nokcha.validationsample.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class MetropolitanCityValidation implements ConstraintValidator<MetropolitanCity, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return List.of("seoul", "inchoen", "deagu", "busan", "gwangju").contains(value.toLowerCase());
    }
}
