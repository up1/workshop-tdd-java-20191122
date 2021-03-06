package com.example.day2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Day2Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication
		.run(Day2Application.class, args);
		
		for(String bean : context.getBeanDefinitionNames()) {
		    System.out.println(bean);
		}
		
		System.out.println("Total bean = " 
		+ context.getBeanDefinitionCount());
	}

}
