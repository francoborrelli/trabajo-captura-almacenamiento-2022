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
		SpringApplication.run(SbpgApplication.class, args);
		logger.info("Starting migrations...");
		logger.info("Finished migrations...");
		logger.info("Application initialized...");
	}
}
