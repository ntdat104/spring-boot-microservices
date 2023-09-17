package com.simplize.productservice.service.converter;

import com.simplize.productservice.model.Product;
import com.simplize.productservice.service.dto.ProductDto;
import com.simplize.productservice.service.form.ProductCreate;
import com.simplize.productservice.service.form.ProductUpdate;

public interface IProductConverter {

    ProductDto convert(Product model, ProductDto dto);

    Product convert(ProductCreate create, Product model);

    Product convert(ProductUpdate update, Product model);

}