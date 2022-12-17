package com.ayushkumar.moviebooking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//@JsonManagedReference
@SpringBootApplication
public class MoviebookingApplication {

	private static final Logger LOGGER=LoggerFactory.getLogger(MoviebookingApplication.class);

	public static void main(String[] args) throws Exception {

		ApplicationContext cxt=SpringApplication.run(MoviebookingApplication.class, args);
		LOGGER.debug("debug mode");
		LOGGER.info("Info mode");
		LOGGER.warn("warn mode");
		LOGGER.error("error mode");

	}

}
