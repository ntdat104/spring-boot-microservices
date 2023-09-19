package com.simplize.inventoryservice.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simplize.inventoryservice.repository.InventoryRepository;
import com.simplize.inventoryservice.service.IInventoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InventoryService implements IInventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    @Transactional(readOnly = true)
    public Boolean isInStock(String skuCode) {
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }

}
