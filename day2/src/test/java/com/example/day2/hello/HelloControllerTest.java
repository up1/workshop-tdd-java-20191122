package com.example.day2.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HelloControllerTest { 
    
    @Autowired
    private UserRepository userRepository;

    @Test
    void hello_api(@Autowired TestRestTemplate restTemplate) {
        User xxx = new User();
        xxx.setId(1L);
        xxx.setName("xxx");
        userRepository.save(xxx);
        
        HelloMessageResponse response = 
                restTemplate.getForObject(
                        "/hello/xxx", HelloMessageResponse.class);
        
        assertEquals("Hello, xxx", response.getMessage());
    }

}
