package com.zest.product.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.zest.product.dto.*;
import com.zest.product.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController 
{
    private final ProductService service;

    public ProductController(ProductService service) 
    {
        this.service = service;
    }

    @PostMapping
    public ProductResponse create(@Valid @RequestBody ProductRequest request) 
    {
        return service.create(request);
    }

    @GetMapping
    public Page<ProductResponse> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) 
    {
        return service.getAll(page, size);
    }

    @GetMapping("/{id}")
    public ProductResponse getById(@PathVariable Long id) 
    {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public ProductResponse update(@PathVariable Long id,
                                  @RequestBody ProductRequest request)
    {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id)
    {
        service.delete(id);
        return "Product deleted successfully";
    }
}