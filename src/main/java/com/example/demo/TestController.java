package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class TestController {

    @GetMapping("/test")
    public String test(String msg) {
        return "testing  " + msg;
    }

    @GetMapping("/aux")
    public String aux(String msg) {
        return "aux  " + msg;
    }
}
