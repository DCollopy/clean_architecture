package br.com.cleanarchitecture.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = "br.com.cleanarchitecture.*")
@EntityScan(basePackages = "br.com.cleanarchitecture.*")
@EnableJpaRepositories(basePackages = "br.com.cleanarchitecture.*")
public class CleanWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(CleanWebApplication.class, args);
    }

}
