package com.jojoldu.book.application.web;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloController.class)
public class HelloControllerTest {
    @Autowired
    private MockMvc mvc;
    @Test
    public void hello() throws Exception {
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("hello")));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name="hello";
        int amount = 1000;
        mvc.perform(get("/hello/dto").param("name", name).param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
        //jsonPath : JSON응답값을 필드별로 검증할 수 있다
    }
}