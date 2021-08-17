package com.nokcha.validationsample.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@RestController
@RequestMapping("param")
@Validated
public class RequestParamController {

    @GetMapping("default")
    @ResponseBody
    public ResponseEntity getDefault(){
        return ResponseEntity.ok("success");
    }

    @GetMapping("validation")
    @ResponseBody
    public ResponseEntity getResource(@RequestParam @Min(1) int no) {
//  an errors/bindingresult argument is expected to be declared immediately after the model attribute,
//  the @requestbody or the @requestpart arguments to which they apply:
//        if (bindingResult.hasErrors()) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
//        }
        return ResponseEntity.ok("success");
    }
}
