package com.example.unittesting.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.hamcrest.core.Is.is;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloController.class)
class HelloControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void helloWorldTest_Basic() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
                get("/hello")
                .accept(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk())
        //2 ways of testing
        //1. Directly in MvcResult using jsonPath
        //If result is simple, direclty make check here itself
        .andExpect(jsonPath("$", is("Hello World")))
        .andReturn();

        //2. Using assertions
        //If the response object is not that easy, we make use of assertions
        assertEquals("Hello World", mvcResult.getResponse().getContentAsString());

    }


}