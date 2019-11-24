package com.example.day2.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.BDDMockito.*;

@WebMvcTest(HelloController.class)
class HelloControllerMockMvcTest {
    
    @Autowired
    private MockMvc mvc;
    
    @MockBean
    private HelloService helloService;

    @Test
    void hello_api() throws Exception {
        // Stub
        given(helloService.getData("xxx"))
        .willReturn("Hello, xxx"); 
        
        // Action
        MvcResult result= this.mvc.perform(
                get("/hello/xxx")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        
        // Assertion
        String body = result.getResponse().getContentAsString();
        ObjectMapper mapper = new ObjectMapper();
        HelloMessageResponse response = 
                mapper.readValue(body, HelloMessageResponse.class);
        
        assertEquals("Hello, xxx", response.getMessage());
    }

}
