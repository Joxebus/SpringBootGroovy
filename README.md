# SpringBootGroovy

## Technologies

- Spring Boot 1.4.0.RELEASE
- Groovy 2.3.11
- Tomcat 7.0.59
- Java 8

## Groovy Sources

First of all the project must to know were to find the `sources` for this we need to add the next line to our *pom.xml* file:

```xml
<build>
    <sourceDirectory>src/main/groovy</sourceDirectory>
    <!-- Some other configurations -->
</build>
```

To see a full example in this project please click [here.](https://raw.githubusercontent.com/Joxebus/SpringBootGroovy/master/pom.xml)

##Spring Boot Groovy Example App

This app is an example of how to build a Spring Boot Application with Groovy in this case we manage the depencies of the project with maven but can do it also with gradle, in a future I will gonna create a branch with a gradle configuration.

## The Application Class

The package `com.nearsoft` is the main package of this application, in here a file named `Application.groovy` is placed, this is the entry point for our Spring Boot Application.

## Controllers

I decide to create a package named `com.nearsoft.controller` in here I will gonna put all my available controllers for this example.

To configure other controllers you can use the annotation `@RestController` in a class level, just like this:

``` java
@RestController
class HelloController {
	// Logic
}
```

## RequestMappings

To configure the URLs that will be available for your application, we use the `@RequestMapping`annotation you can define also if the request method will be GET, POST, PUT or DELETE and also if consumes XML, JSON or another configuration and the same for the response.

```java
@RequestMapping(value = "/",
        method = RequestMethod.POST,   // Optional
        consumes = "application/json", // Optional
        produces = "application/json") // Optional
def index(){
    "Hello World!"
}
```

For more information about `@RestController` and `@RequesMapping` please read the official info [here.](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#getting-started-first-application-annotations)

## application.yml

By *default* a Spring Boot Application will gonna look for an `application.properties` or `application.yml`, in this file we can setup the port, the server context path, logging, and other.

You can find more common Application Properties [here.](http://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html)

## Logging

To enable logging into your class use the next annotation `@Slf4j` in your class, this will inject the object `log` and you can use is as below:

```java
@RestController
@Slf4j
class HelloController {

    @PostConstruct
    def init(){
        log.info 'Controller generated' // You can use log.{ info | debug | error | warn }
    }

    // Other methods
}
``` 


### Run your project

```
mvn spring-boot:run
```

### See the results

```
http://localhost:8080
```

If everything goes well you will see on your web browser the message bellow:

# Hello World!