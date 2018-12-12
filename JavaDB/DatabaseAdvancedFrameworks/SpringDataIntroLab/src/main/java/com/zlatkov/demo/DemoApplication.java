package com.zlatkov.demo;

import com.zlatkov.demo.repositories.base.DataRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public DemoApplication(DataRepository dataRepository) {
        dataRepository.list()
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
