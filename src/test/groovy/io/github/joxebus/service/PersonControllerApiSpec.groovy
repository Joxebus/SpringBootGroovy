package io.github.joxebus.service

import io.github.joxebus.controller.PersonController
import io.github.joxebus.domain.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import spock.lang.Ignore
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonControllerApiSpec extends Specification {

    @Autowired
    PersonController personController
    @Autowired
    TestRestTemplate restTemplate

    def setup() {
        // do login
        // restTemplate.postForEntity("/login", )
    }

    def "Person controller return the list of people"() {
        setup: "Get list"
        def entity = restTemplate.getForEntity("/people/api/", List)

        expect: "status code OK and values are the expected"
        entity.statusCode    == HttpStatus.OK
        entity.body instanceof List
    }

    @Ignore
    def "/people/api/{id} should return an element"(){
        when: "Get person"
        def entity = restTemplate.getForEntity("/people/api/1", Person)

        then: "Verify the response is 200 and data equals as the first element"
        entity.statusCode    == HttpStatus.OK
        entity.body.id       == 1
        entity.body.name     == 'Omar'
        entity.body.lastName == 'Bautista'
        entity.body.email    == 'obautista@email.com'
    }
}
