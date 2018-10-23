package com.nearsoft.service.impl

import com.nearsoft.domain.Person
import com.nearsoft.service.PersonService
import grails.gorm.transactions.Transactional
import org.springframework.stereotype.Service

@Service
@Transactional
class PersonServiceImpl implements PersonService {

    @Override
    List<Person> findAll() {
        Person.findAll()
    }

    @Override
    Person findById(Long id) {
        Person.findById(id)
    }

    @Override
    Person save(Person person) {
        person.validate()
        if(person.hasErrors()){
            throw new Exception("Person fields are incorrect.")
        }
        person.save(flush:true)
    }

    @Override
    boolean delete(Long id){
        Person person = findById(id)
        if(person) person.delete(flush:true)
    }
}
