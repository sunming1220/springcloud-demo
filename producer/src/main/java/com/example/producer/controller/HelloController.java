package com.example.producer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sunming on 2019/6/11.
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index(@RequestParam String name){

        return "hello"+name+",this is first message";
    }
}
