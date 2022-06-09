package com.products.sbpg;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.products.sbpg.model.Brand;
import com.products.sbpg.model.Product;
import com.products.sbpg.repository.JPABrandRepository;
import com.products.sbpg.repository.JPAProductRepository;

import me.tongfei.progressbar.ProgressBar;

import java.util.Optional;
import java.util.Scanner;
import java.io.File; 

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
        productRepository.deleteAll();
        brandRepository.deleteAll();

        ClassLoader classLoader = getClass().getClassLoader();
        String path = classLoader.getResource("products.tsv").getFile();
        File file = new File(path);

        try (Scanner scanner = new Scanner(file);) {
            // try-with-resource block
            try (ProgressBar pb = new ProgressBar("Importando productos", file.length())) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] item = line.split("\\t");
                    if (item.length == 3) {
                        Brand brand = brandRepository.findOrCreate(item[1]);
                        logger.info(item[0]);
                        logger.info(item[1]);
                        logger.info(item[2]);
                        productRepository.save(new Product(item[0], item[2], brand));
                    }
                    pb.step(); // step by 1
                }
            } 
        }
    }
}

