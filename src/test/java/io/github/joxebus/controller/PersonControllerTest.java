package io.github.joxebus.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
public class PersonControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void listPeople() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/people/").accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("person/list"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Person list")));
    }

    @Test
    public void listPeopleApi() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/people/api")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Omar")));
    }

    @Test
    public void getPersonById() throws Exception {
        mvc.perform( MockMvcRequestBuilders
                .get("/people/api/{id}", 1)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
    }

    @Test
    public void showForm() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/people/new").accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("person/create"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Person Create")))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("fieldName")))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("fieldLastName")))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("fieldEmail")))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Submit")));
    }
}
