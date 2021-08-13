package com.nokcha.validationsample.dto;

import com.nokcha.validationsample.validation.group.UserValidationGroup;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
public class UserDto {
    @Min(value = 1, groups = {UserValidationGroup.ageValidationGroup.class, UserValidationGroup.allValidationGroup.class})
    int age;

    @Size(min = 1, max = 3, groups = {UserValidationGroup.nameValidationGroup.class, UserValidationGroup.allValidationGroup.class})
    String name;
}
