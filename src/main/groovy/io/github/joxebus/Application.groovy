package io.github.joxebus

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration

/**
 * Exclude the HibernateJpaAutoConfiguration to avoid
 * the following class cast exception
 *
 * java.lang.ClassCastException org.springframework.orm.jpa.EntityManagerHolder cannot be cast to org.springframework.orm.hibernate5.SessionHolder
 */
@SpringBootApplication (exclude = HibernateJpaAutoConfiguration.class )
class Application {

    static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
