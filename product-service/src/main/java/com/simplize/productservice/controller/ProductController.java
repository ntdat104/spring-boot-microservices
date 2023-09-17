package com.simplize.productservice.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplize.productservice.service.form.ProductCreate;
import com.simplize.productservice.service.form.ProductUpdate;
import com.simplize.productservice.service.impl.ProductService;
import com.simplize.productservice.util.Response;
import com.simplize.productservice.util.ResponsePage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    public final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponsePage<?> findAll(@RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false, defaultValue = "createdDate") String sortBy,
            @RequestParam(required = false, defaultValue = "desc") String sortOrder) {
        return ResponsePage.data(productService.findAll(page, size, sortBy, sortOrder));
    }

    @GetMapping("{id}")
    public Response<?> findById(@PathVariable("id") String id) {
        return Response.data(productService.findById(id));
    }

    @PostMapping()
    public Response<?> create(@RequestBody ProductCreate create) {
        return Response.data(productService.create(create));
    }

    @PutMapping("{id}")
    public Response<?> update(@PathVariable("id") String id, @RequestBody ProductUpdate update) {
        return Response.data(productService.update(id, update));
    }

    @DeleteMapping("{id}")
    public Response<?> delete(@PathVariable("id") String id) {
        return Response.data(productService.delete(id));
    }

}
