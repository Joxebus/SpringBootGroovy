# SpringBootGroovy

## Technologies

- Spring Boot Parent POM 2.3.1.RELEASE
- Groovy 2.5.12
- GORM 7.0.3.RELEASE
- Hibernate Core / Ecache 5.4.18.Final
- Tomcat JDBC 8.5.0
- Java 8
- Thymeleaf 

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

The package `io.github.joxebus` is the main package of this application, in here a file named `Application.groovy` is placed, this is the entry point for our Spring Boot Application.

## Controllers

I decide to create a package named `io.github.joxebus.controller` in here I will gonna put all my available controllers for this example.

To configure other controllers you can use the annotation `@RestController` or `@Controller` in a class level, just like this:

``` java
@RestController // Change for @Controller if you are using thymeleaf to serve the views
class HelloController {
	// Logic
}
```

## RequestMappings

To configure the URLs that will be available for your application, we use the `@RequestMapping` annotation you can define also if the request method will be GET, POST, PUT or DELETE and also if consumes XML, JSON or another configuration and the same for the response.

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

## Rendering a view

To render a view you only need to create a class with `@Controller` annotation to make this class a Spring component and a Spring MVC controller, for example if you want to show the view `index.html` you just need to follow the convention, returning the name of the template less the extension of the file placed in the _templates_ folder, follow the next example:


### Index Controller
```java

@Controller
class IndexController {

    @RequestMapping("/")
    def index(Model model){
        log.info 'Calling index method'
        model.addAttribute('greeting', 'Hello World!')
        'index'	 // This will be look for a matching template named index.html
    }
}
```

### Index View
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head lang="en">
    <title>Hello Spring Boot!</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
    <h1 th:text="${greeting}"></h1>
</body>
</html>
```

**Note:** Don't forget to include the namespace in the root tag `<html xmlns:th="http://www.thymeleaf.org">`

### Run your project

```
./mvnw spring-boot:run
```

### Access H2 database

```
http://localhost:8080/test/console
```

### See the results

```
http://localhost:8080/test
```

If everything goes well you will see on your web browser the message bellow:

# Hello World!



--------
### Related Links
- Fátima Casaú *InfoQ*: [Spring Boot and Groovy](https://www.infoq.com/presentations/spring-groovy-gorm)
- Dan Vega *Article*: [Using GORM in Spring Boot](http://therealdanvega.com/blog/2015/11/25/using-gorm-in-spring-boot)
- GORM 5: [Official Site](http://gorm.grails.org/latest/)
- H2 Spring Boot Configuration: [Spring IO - Official Site](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-sql-h2-console)
- Application Properties: [Spring IO - Official Site](http://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html)
- Handling Form Submission with Thymeleaf: [Spring IO - Official Site Examples](https://spring.io/guides/gs/handling-form-submission/)
