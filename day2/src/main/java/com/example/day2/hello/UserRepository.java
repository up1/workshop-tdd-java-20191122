package com.example.day2.hello;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository 
       extends CrudRepository<User, Long> {
    
    Optional<User> findByName(String name);

}