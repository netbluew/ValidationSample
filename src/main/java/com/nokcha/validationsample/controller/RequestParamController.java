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

//  https://leejongchan.tistory.com/24
//  그 이유는 Spring Boot Application이 Validation check를 하도록 trigger하는 코드가 없기 때문이다.
//  이렇게 Controller method 매개 변수에 직접 제약 조건을 추가하는 경우에는 Controller에 @Validated를 선언하여 Validation check를 할 수 있도록 한다.
//  단 Controller 에 Validated 를 선언 할 경우, 하위에 @Valid Annotation 을 사용하는 Method 가 존재하면, Validation 이 2번 수행 될 수 있다.
//  이때 @Valid 가 아닌 @Validated Annotation 을 사용하면 1번 수행으로 처리 될 수도 있다.

//  Validation 을 사용하고자 할 경우 @RequestParam Annotation 을 사용하여야 한다.

//  Validation check 실패시 Application에서 getName은 Http status code 500(Internal Server Error)
    public ResponseEntity getResource(@RequestParam @Min(1) int no) {
//  an errors/bindingresult argument is expected to be declared immediately after the model attribute,
//  the @requestbody or the @requestpart arguments to which they apply:
//        if (bindingResult.hasErrors()) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
//        }
        return ResponseEntity.ok("success");
    }
}
