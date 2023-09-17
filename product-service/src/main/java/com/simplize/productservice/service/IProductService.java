package com.simplize.productservice.service;

import org.springframework.data.domain.Page;

import com.simplize.productservice.service.dto.ProductDto;
import com.simplize.productservice.service.form.ProductCreate;
import com.simplize.productservice.service.form.ProductUpdate;

public interface IProductService {

    Page<ProductDto> findAll(Integer page, Integer size, String sortBy, String sortOrder);

    ProductDto findById(String id);

    ProductDto create(ProductCreate create);

    ProductDto update(String id, ProductUpdate update);

    ProductDto delete(String id);

}
