package com.products.sbpg.benchmark;


import java.util.Collections;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
// import org.openjdk.jmh.runner.Runner;
// import org.openjdk.jmh.runner.RunnerException;
// import org.openjdk.jmh.runner.options.Options;
// import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.springframework.web.reactive.function.client.WebClient;

public class ProductsBenchmark {
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void doExection() throws InterruptedException {
        WebClient client = WebClient.builder().baseUrl("http://localhost:8080/api/elastic/products/search/{term}").defaultUriVariables(Collections.singletonMap("term", "milk")).build();
        client.get().retrieve().toString();
    }

}





