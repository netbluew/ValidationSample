package com.nokcha.validationsample.dto;

import com.nokcha.validationsample.validation.MetropolitanCity;
import lombok.Data;

@Data
public class AddressDto {
    @MetropolitanCity
    String city;
}
