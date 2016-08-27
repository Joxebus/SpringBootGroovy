package com.nearsoft.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.annotation.PostConstruct

@RestController
class HelloController {

    @PostConstruct
    def init(){
        println 'Controller generated'
    }

    @RequestMapping("/")
    def index(){
        "Hello World!"
    }
}
