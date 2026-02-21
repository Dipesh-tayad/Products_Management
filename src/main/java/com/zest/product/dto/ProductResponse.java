package com.zest.product.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public class ProductResponse 
{
    private Long id;
    @NotBlank(message = "Product name is required")
    private String productName;
    @NotBlank(message = "Created by is required")
    private String createdBy;
    private LocalDateTime createdOn;

    public ProductResponse(Long id, String productName,
                           String createdBy, LocalDateTime createdOn) 
    {
        this.id = id;
        this.productName = productName;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
    }

    public Long getId() 
    {
        return id;
    }

    public String getProductName()
    {
        return productName;
    }

    public String getCreatedBy()
    {
        return createdBy;
    }

    public LocalDateTime getCreatedOn() 
    {
        return createdOn;
    }
}