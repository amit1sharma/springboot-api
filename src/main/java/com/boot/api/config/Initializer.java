package com.boot.api.config;

import com.boot.api.enums.Department;
import com.boot.api.model.Customer;
import com.boot.api.repository.ItemRestRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class Initializer implements CommandLineRunner {

    private final ItemRestRepository itemRestRepository;

    public Initializer(ItemRestRepository itemRestRepository) {
        this.itemRestRepository = itemRestRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of("Amit", "Ankush", "Prateek", "Sahul", "Ayesha", "Vikas","Shoba")
                .forEach(name -> itemRestRepository.save(new Customer(name, Department.JAVA)));

        Stream.of("Sharad", "Rahul", "Sher", "Pramod", "Karol", "Vikas", "Riyas", "Simyan", "Abhishek")
                .forEach(name -> itemRestRepository.save(new Customer(name, Department.MS)));

        Stream.of("Sirish", "Ashutosh", "Neena")
                .forEach(name -> itemRestRepository.save(new Customer(name, Department.ETL)));

        itemRestRepository.findAll().forEach(System.out::println);
    }
}
