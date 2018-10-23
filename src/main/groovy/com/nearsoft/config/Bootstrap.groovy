package com.nearsoft.config

import com.nearsoft.domain.Person
import com.nearsoft.service.PersonService
import grails.gorm.transactions.Transactional
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationContext
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

/**
 * This class has been created to load information
 * just after application has been loaded.
 */

@Component
@Slf4j
@Transactional
class Bootstrap {

    @Autowired
    PersonService personService

    @Autowired
    private ApplicationContext ctx;

    @EventListener
    def init(ApplicationReadyEvent ready){

        if(!Person.count()){
            log.info "--------- INIT Loading information ---------"
            def persons = [
                    new Person(name: "Omar", lastName:"Bautista", email:'obautista@email.com'),
                    new Person(name:"Jorge", lastName:"Valenzuela", email:'jvalenzuela@email.com')
            ]

            log.info("About to load users: ${persons}")

            // Save person if validation constraints are met
            persons.each { person ->
                if (personService.save(person)) {
                    log.info("Successfully saved ${person}")
                }

            }
            log.info "--------- FINISH Loading information ---------"
        } else {
            log.info("--------- Nothing to load ---------")
        }



    }
}
