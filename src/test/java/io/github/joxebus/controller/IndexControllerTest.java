package io.github.joxebus.controller;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class IndexControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void sayHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.TEXT_HTML))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Spring Boot + Groovy + GORM + Thymeleaf")))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Groovy")))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("GORM")))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Thymeleaf")));
    }
}
