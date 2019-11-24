package com.example.day2.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @Autowired
    private HelloService helloService;
    
    @GetMapping("/hello/{name}")
    public HelloMessageResponse sayHi(
            @PathVariable String name) {
        String result = helloService.getData(name);
        return new HelloMessageResponse(result);
    }

}
