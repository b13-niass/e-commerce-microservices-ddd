package com.codev.ecommerce.payment;

import com.codev.ecommerce.customer.CustomerResponse;
import com.codev.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
