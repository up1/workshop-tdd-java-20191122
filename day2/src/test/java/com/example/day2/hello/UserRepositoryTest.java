package com.example.day2.hello;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void found_user_xxx() {
        User xxx = new User();
        xxx.setId(1L);
        xxx.setName("xxx");
        userRepository.save(xxx);
        
        Optional<User> userOptional 
            = userRepository.findByName("xxx");
        
        assertTrue(userOptional.isPresent());
        assertEquals("xxx", userOptional.get().getName());
    }

}
