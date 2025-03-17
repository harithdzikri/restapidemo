package com.luv2code.restapidemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {

    //Add code for rest hello

    @GetMapping("/hello")
    public String myHello(){
        return "Hello World!";
    }
}
