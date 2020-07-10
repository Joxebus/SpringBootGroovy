package io.github.joxebus.service


import io.github.joxebus.domain.Person


interface PersonService {

    Person save(Person person)
    boolean delete(Long id)
    Person findById(Long id)
    List<Person> findAll()
}
