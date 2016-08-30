package com.nearsoft.service

import com.nearsoft.domain.Person


interface PersonService {

    Person save(Person person)
    boolean delete(Long id)
    Person findById(Long id)
    List<Person> findAll()
}
