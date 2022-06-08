package com.products.sbpg;


import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.products.sbpg.model.Brand;
import com.products.sbpg.model.Product;
import com.products.sbpg.repository.JPABrandRepository;
import com.products.sbpg.repository.JPAProductRepository;

@Component
public class SeedRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SeedRunner.class);

    private static Faker faker = new Faker();
    
    @Inject
    private final JPAProductRepository productRepository;

    @Inject
    private final JPABrandRepository brandRepository;

    @Override
    public void run(String... args) throws Exception {
        // faker.commerce().productName();
        brandRepository.deleteAll();
        productRepository.deleteAll();

        for (long index = 0; index < 300; index++) {
            brandRepository.save(new Brand(faker.company().name()));
        }

        for (long index = 0; index < 10000; index++) {
            productRepository.save(new Product(faker.company().name(), faker.company().bs()));
        }

        repository.save(new Brand("Bratislava", 432000));
        repository.save(new City("Budapest", 1759000));
        repository.save(new City("Prague", 1280000));

        repository.findAll().forEach((city) -> {
            logger.info("{}", city);
        });
    }
}

