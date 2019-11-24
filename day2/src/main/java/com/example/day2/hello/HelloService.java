package com.example.day2.hello;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    private UserRepository userRepository;
    
    @Autowired
    public HelloService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getData(String name) {
        Optional<User> userOptional 
             = userRepository.findByName(name);
        if (userOptional.isPresent()) {
            return "Hello, " + userOptional.get().getName();
        }
        return "Error";
    }

}
