package com.neoris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.neoris"})
@EnableJpaRepositories(basePackages = {"com.neoris.Cajero.repository"})
public class CajeroNeorisApplication {

    public static void main(String[] args) {
        SpringApplication.run(CajeroNeorisApplication.class, args);
    }

}