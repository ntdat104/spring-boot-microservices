package com.simplize.productservice.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.simplize.productservice.model.Product;
import com.simplize.productservice.repository.ProductRepository;
import com.simplize.productservice.service.IProductService;
import com.simplize.productservice.service.converter.impl.ProductConverter;
import com.simplize.productservice.service.dto.ProductDto;
import com.simplize.productservice.service.form.ProductCreate;
import com.simplize.productservice.service.form.ProductUpdate;

@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    public ProductService(ProductRepository productRepository, ProductConverter productConverter) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;
    }

    @Override
    public ProductDto create(ProductCreate create) {
        Product product = productConverter.convert(create, new Product());

        Product productSaved = productRepository.save(product);

        ProductDto productDto = productConverter.convert(productSaved, new ProductDto());

        return productDto;
    }

    @Override
    public ProductDto delete(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy dữ liệu!"));

        productRepository.delete(product);

        ProductDto productDto = productConverter.convert(product, new ProductDto());

        return productDto;
    }

    @Override
    public Page<ProductDto> findAll(Integer page, Integer size, String sortBy, String sortOrder) {
        Sort sort = sortOrder.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Product> pageProduct = productRepository.findAll(pageable);

        Page<ProductDto> pageProductDto = pageProduct
                .map((entity) -> productConverter.convert(entity, new ProductDto()));

        return pageProductDto;
    }

    @Override
    public ProductDto findById(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy dữ liệu!"));

        ProductDto productDto = productConverter.convert(product, new ProductDto());

        return productDto;
    }

    @Override
    public ProductDto update(String id, ProductUpdate update) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy dữ liệu!"));
        
        Product productUpdated = productConverter.convert(update, product);

        Product productSaved = productRepository.save(productUpdated);

        ProductDto productDto = productConverter.convert(productSaved, new ProductDto());

        return productDto;
    }

}
