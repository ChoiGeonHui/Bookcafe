package com.bookcafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BookcafeApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(BookcafeApplication.class, args);
	}

}
