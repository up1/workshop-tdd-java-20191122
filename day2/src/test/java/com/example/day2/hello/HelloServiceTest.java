package com.example.day2.hello;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.*;

import java.util.Optional;

public class HelloServiceTest {
    
    private UserRepository userRepository;

    @Test
    void user_not_found_return_Error() {
        userRepository = mock(UserRepository.class);
        given(userRepository.findByName("xxx"))
        .willReturn(Optional.empty());
        
        HelloService helloService = new HelloService(userRepository);
        String result = helloService.getData("xxx");
        assertEquals("Error", result);
    }

}
