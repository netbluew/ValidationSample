package com.nokcha.validationsample.dto;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class ImageDto {
    @Min(value=1)
    int no;

    @Min(value=1, message = "커스텀 메세지 1 이상")
    int size;
}
