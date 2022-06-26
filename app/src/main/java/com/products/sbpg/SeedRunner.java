package com.products.sbpg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import com.products.sbpg.model.Brand;
import com.products.sbpg.model.Product;
import com.products.sbpg.repository.PostgresBrandRepository;
import com.products.sbpg.repository.PostgresProductRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class SeedRunner implements CommandLineRunner {
    @Value("${sample.size}")
    String sampleSizeConfig;

    private static final Logger logger = LoggerFactory.getLogger(SeedRunner.class);

    private final PostgresBrandRepository brandRepository;
    private final PostgresProductRepository productRepository;

    public SeedRunner(PostgresBrandRepository brandRepository, PostgresProductRepository productRepository) {
        this.brandRepository = brandRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // double sampleSize = SampleSize.valueOf(sampleSizeConfig).getSizePercentage();

        // logger.info(" -------------------------------------");
        // logger.info("SAMPLE SIZE: " + sampleSizeConfig + " (" + sampleSize + ")");
        // logger.info(" -------------------------------------");

        // this.brandRepository.deleteAll();
        // this.brandRepository.flush();
        // this.productRepository.deleteAll();
        // this.productRepository.flush();

        // ClassLoader classLoader = getClass().getClassLoader();
        // String path = classLoader.getResource("products.tsv").getFile();

        // int lineCount = 0;
        // String line;

        // int totalLines = (int) Files.lines(Paths.get(path)).count();
        // logger.info(" -------------------------------------");
        // logger.info("| COMENZANDO IMPORTACIÓN DE PRODUCTOS |");
        // logger.info(" -------------------------------------");

        // try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path), 65536);) {
        //     while ((line = bufferedReader.readLine()) != null && lineCount  <= totalLines * sampleSize) {
        //         String[] item = line.split("\\t", -1);
        //         Brand brand = brandRepository.findOrCreate(item[2]);
        //         productRepository.save(new Product(item[1], item[3], brand));
        //         lineCount++;
        //         if (lineCount % 10000 == 0) {
        //             logger.info("Cargando datos, completado al {}%",
        //                     String.format("%.02f", (100 * lineCount) / (totalLines * sampleSize)));
        //         }
        //     }
        // }
        // logger.info(" -------------------------------------");
        // logger.info("| IMPORTACIÓN DE PRODUCTOS FINALIZADA |");
        // logger.info(" -------------------------------------");
    }
}
