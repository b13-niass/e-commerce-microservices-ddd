package com.codev.ecommerce.orderline;

import jakarta.validation.constraints.NotNull;

public record OrderLineRequest(
        Integer id,
        Integer orderId,
        @NotNull(message = "Product ID is mandatory")
        Integer productId,
        @NotNull(message = "Quantity is mandatory")
        double quantity
) {
}
