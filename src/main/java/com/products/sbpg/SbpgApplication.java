package com.products.sbpg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.*;


/**
 * Clase principal de la aplicación.
 * 
 * @author Borrelli Franco Martín
 * @author Carbone José Ignacio
 *
 */
@SpringBootApplication
public class SbpgApplication {

	// logger
	private static final Logger logger = LoggerFactory.getLogger(SbpgApplication.class);

	public static void main(String[] args) {
		logger.info("Application initialized...");
		SpringApplication.run(SbpgApplication.class, args);
	}

}
