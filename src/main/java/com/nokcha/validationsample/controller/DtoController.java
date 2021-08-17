package com.nokcha.validationsample.controller;

import com.nokcha.validationsample.dto.ImageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("dto")
public class DtoController {

    @PostMapping("insert")
    public ResponseEntity insertImage(@Valid @RequestBody ImageDto image)
    {
        return ResponseEntity.ok(image);
    }

    @PostMapping("insertAfterResponseBindingResult")
    public ResponseEntity insertAfterResponseBindingResult(@Valid @RequestBody ImageDto image, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
        }
        return ResponseEntity.ok(image);
    }

    @PostMapping("insertAfterResponseError")
    public ResponseEntity insertAfterResponseError (@Valid @RequestBody ImageDto image, Errors errors)
    {
        if (errors.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.getAllErrors());
        }
        return ResponseEntity.ok(image);
    }

}
