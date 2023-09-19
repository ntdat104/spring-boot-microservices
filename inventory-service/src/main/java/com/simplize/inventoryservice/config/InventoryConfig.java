package com.simplize.inventoryservice.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.simplize.inventoryservice.model.Inventory;
import com.simplize.inventoryservice.repository.InventoryRepository;

@Configuration
public class InventoryConfig {

    @Bean
    CommandLineRunner commandLineRunner(InventoryRepository inventoryRepository) {
        return args -> {
            inventoryRepository.saveAll(
                    List.of(
                            new Inventory("iphone_13", 100),
                            new Inventory("iphone_13_red", 0),
                            new Inventory("iphone_13_blue", 50)));
        };
    }
}
