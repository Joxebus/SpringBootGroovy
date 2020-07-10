package io.github.joxebus.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import grails.gorm.annotation.Entity


@Entity
@JsonIgnoreProperties(["errors","attached", "dirtyPropertyNames", "dirty"])
class Person {

    String name
    String lastName
    String email


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
