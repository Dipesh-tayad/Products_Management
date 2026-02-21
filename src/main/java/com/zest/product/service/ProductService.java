package com.zest.product.service;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.zest.product.dto.*;
import com.zest.product.entity.Product;
import com.zest.product.repository.ProductRepository;

import java.time.LocalDateTime;


@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public ProductResponse create(ProductRequest request) {

        Product product = new Product();
        product.setProductName(request.getProductName());
        product.setCreatedBy("ADMIN");
        product.setCreatedOn(LocalDateTime.now());

        Product saved = repository.save(product);

        return new ProductResponse(
                saved.getId(),
                saved.getProductName(),
                saved.getCreatedBy(),
                saved.getCreatedOn()
        );
    }

    // READ ALL (Pagination)
    public Page<ProductResponse> getAll(int page, int size) {

        return repository.findAll(PageRequest.of(page, size))
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getProductName(),
                        product.getCreatedBy(),
                        product.getCreatedOn()
                ));
    }

    // READ BY ID
    public ProductResponse getById(Long id) {

        Product product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return new ProductResponse(
                product.getId(),
                product.getProductName(),
                product.getCreatedBy(),
                product.getCreatedOn()
        );
    }

    // UPDATE
    public ProductResponse update(Long id, ProductRequest request) {

        Product product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setProductName(request.getProductName());

        Product updated = repository.save(product);

        return new ProductResponse(
                updated.getId(),
                updated.getProductName(),
                updated.getCreatedBy(),
                updated.getCreatedOn()
        );
    }

    // DELETE
    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }

        repository.deleteById(id);
    }
}