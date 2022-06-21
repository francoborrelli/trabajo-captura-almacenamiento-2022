package com.products.sbpg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.products.sbpg.benchmark.ProductsBenchmark;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.slf4j.*;

/**
 * Clase principal de la aplicación.
 * 
 * @author Borrelli Franco Martín
 * @author Carbone José Ignacio
 *
 */
@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.products.sbpg.search")
@EnableJpaRepositories("com.products.sbpg.repository")
public class SbpgApplication {
	// logger
	private static final Logger logger = LoggerFactory.getLogger(SbpgApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SbpgApplication.class, args);
		logger.info("Application initialized...");

		try {
			Options opt = new OptionsBuilder()
			.include(ProductsBenchmark.class.getSimpleName())
			.forks(2)
			.build();
        	new Runner(opt).run();
		} catch (Exception e) {
		}

	}
}
