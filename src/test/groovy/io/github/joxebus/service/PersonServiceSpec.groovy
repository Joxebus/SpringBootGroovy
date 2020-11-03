package io.github.joxebus.service

import io.github.joxebus.domain.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonServiceSpec extends Specification {

    @Autowired
    PersonService personService

    def "PersonService can get people from DB"() {
        setup:
        def people = personService.findAll()

        expect:
        !people.isEmpty()
    }

}
