package com.codev.ecommerce.email;

import lombok.Getter;

public enum EmailTemplate {
    PAYMENT_CONFIRMATION("payment-confirmation.html", "Payment successfuly processed"),
    ORDER_CONFIRMATION("order-confirmation.html", "Order successfuly processed");

    @Getter
    private final String template;
    @Getter
    private final String subject;

    EmailTemplate(String template, String subject) {
        this.template = template;
        this.subject = subject;
    }
}
