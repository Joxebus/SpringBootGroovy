package com.nearsoft.controller

import groovy.util.logging.Slf4j
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import javax.annotation.PostConstruct

@RestController
@Slf4j
class HelloController {

    @PostConstruct
    def init(){
        log.info 'Controller generated'
    }

    @RequestMapping(value = "/",
        method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json")
    def index(){
        "Hello World!"
    }
}
