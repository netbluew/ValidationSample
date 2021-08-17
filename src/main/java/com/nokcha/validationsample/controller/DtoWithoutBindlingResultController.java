package com.nokcha.validationsample.controller;


import com.nokcha.validationsample.dto.ImageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("dtowithoutbindlingresult")
public class DtoWithoutBindlingResultController {

    @PostMapping("insert")
    public ResponseEntity insert(@Valid @RequestBody ImageDto image) {
        return ResponseEntity.ok(image);
    }
}
