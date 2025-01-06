package com.ilyaKovalenko.library.LibraryOnTheMargin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LibraryOnTheMarginApplication {

	//Todo: refactor
	//Todo: add publish/unpublish notes
	//Todo: make notes be structred as tree
	public static void main(String[] args) {
		SpringApplication.run(LibraryOnTheMarginApplication.class, args);
	}

}
