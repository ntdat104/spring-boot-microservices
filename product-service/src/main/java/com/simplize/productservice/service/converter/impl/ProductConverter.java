package com.simplize.productservice.service.converter.impl;

import org.springframework.stereotype.Component;

import com.simplize.productservice.model.Product;
import com.simplize.productservice.service.converter.IProductConverter;
import com.simplize.productservice.service.dto.ProductDto;
import com.simplize.productservice.service.form.ProductCreate;
import com.simplize.productservice.service.form.ProductUpdate;

@Component
public class ProductConverter implements IProductConverter {

    @Override
    public ProductDto convert(Product model, ProductDto dto) {
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setDescription(model.getDescription());
        dto.setPrice(model.getPrice());
        return dto;
    }

    @Override
    public Product convert(ProductCreate create, Product model) {
        model.setName(create.getName());
        model.setDescription(create.getDescription());
        model.setPrice(create.getPrice());
        return model;
    }

    @Override
    public Product convert(ProductUpdate update, Product model) {
        if (update.getId() != null) {
            model.setId(update.getId());
        }
        if (update.getName() != null) {
            model.setName(update.getName());
        }
        if (update.getDescription() != null) {
            model.setDescription(update.getDescription());
        }
        if (update.getPrice() != null) {
            model.setPrice(update.getPrice());
        }
        return model;
    }

}
