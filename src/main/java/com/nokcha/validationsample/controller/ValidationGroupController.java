package com.nokcha.validationsample.controller;

import com.nokcha.validationsample.dto.UserDto;
import com.nokcha.validationsample.validation.group.UserValidationGroup;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("group")
public class ValidationGroupController {

    @PostMapping("insert")
    public ResponseEntity insert(@Validated(UserValidationGroup.allValidationGroup.class) @RequestBody UserDto user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
        }
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping("insertWithAgeOnly")
    public ResponseEntity insertWithAgeOnly(@Validated(UserValidationGroup.ageValidationGroup.class) @RequestBody UserDto user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
        }
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping("insertWithNameOnly")
    public ResponseEntity insertWithNameOnly(@Validated(UserValidationGroup.nameValidationGroup.class) @RequestBody UserDto user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
        }
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
