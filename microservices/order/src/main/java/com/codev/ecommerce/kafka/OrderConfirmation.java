package com.codev.ecommerce.kafka;

import com.codev.ecommerce.customer.CustomerResponse;
import com.codev.ecommerce.order.PaymentMethod;
import com.codev.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,

        List<PurchaseResponse> products
) {
}
