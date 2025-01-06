package com.ilyaKovalenko.library.LibraryOnTheMargin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LibraryOnTheMarginApplication {

	//Todo: refactor
	//Todo: Make user to get only his notes
	public static void main(String[] args) {
		SpringApplication.run(LibraryOnTheMarginApplication.class, args);
	}

}
