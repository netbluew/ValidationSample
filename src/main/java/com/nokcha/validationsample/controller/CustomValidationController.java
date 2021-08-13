package com.nokcha.validationsample.controller;

import com.nokcha.validationsample.dto.AddressDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("custom")
public class CustomValidationController {

    @PostMapping("insert")
    public ResponseEntity insert(@Valid @RequestBody AddressDto address, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
        }
        return ResponseEntity.ok(address);
    }
}
