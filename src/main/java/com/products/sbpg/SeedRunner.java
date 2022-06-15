package com.products.sbpg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.products.sbpg.model.Brand;
import com.products.sbpg.model.Product;
import com.products.sbpg.repository.JPABrandRepository;
import com.products.sbpg.repository.JPAProductRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class SeedRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SeedRunner.class);
    

    private final JPABrandRepository brandRepository;
    private final JPAProductRepository productRepository;

    public SeedRunner(JPABrandRepository brandRepository, JPAProductRepository productRepository) {
        this.brandRepository = brandRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String path = classLoader.getResource("products.tsv").getFile();

        int lineCount = 0;
        String line;

        int totalLines = (int) Files.lines(Paths.get(path)).count();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path), 65536);) {
            while((line = bufferedReader.readLine()) != null)
            {
                String[] item = line.split("\\t");
                if (item.length == 3) {
                    Brand brand = brandRepository.findOrCreate(item[2]);
                    productRepository.save(new Product(item[0], item[1], brand));
                }
                lineCount++;
                if(lineCount % 10000 == 0) {
                    logger.info("Cargando datos, completado al {}%", String.format("%.02f", 100 * lineCount / (float) totalLines));
                }
            }
        }
    }
}

