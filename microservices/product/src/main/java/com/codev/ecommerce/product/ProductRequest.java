package com.codev.ecommerce.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(
        Integer id,
        @NotNull(message = "Product name is required")
        String name,
        @NotNull(message = "Product description is required")
        String description,
        @NotNull(message = "Product available quantity is required")
        @Positive(message = "Product available quantity must be positive")
        Double availableQuantity,
        @NotNull(message = "Product price is required")
        @Positive(message = "Product price must be positive")
        BigDecimal price,
        @NotNull(message = "Product category ID is required")
        @Positive(message = "Product category ID must be positive")
        Integer categoryId
) {
}
