package com.simplize.inventoryservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplize.inventoryservice.service.impl.InventoryService;
import com.simplize.inventoryservice.util.Response;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{sku-code}")
    public Response<?> isInStock(@PathVariable("sku-code") String skuCode) {
        return Response.data(inventoryService.isInStock(skuCode));
    }

}
