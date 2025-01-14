package com.codev.ecommerce.kafka.order;

import java.math.BigDecimal;

public record Product(
        Integer productId,
        String name,
        BigDecimal price,
        String description,
        double quantity
) {
}
