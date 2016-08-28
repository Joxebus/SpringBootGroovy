package com.nearsoft.controller

import groovy.util.logging.Slf4j
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

import javax.annotation.PostConstruct

@Controller
@Slf4j
class IndexController {

    @PostConstruct
    def init(){
        log.info 'Controller generated'
    }

    @RequestMapping("/")
    def index(Model model){
        log.info 'Calling index method'
        model.addAttribute('greeting', 'Hello World!')
        'index'
    }
}
