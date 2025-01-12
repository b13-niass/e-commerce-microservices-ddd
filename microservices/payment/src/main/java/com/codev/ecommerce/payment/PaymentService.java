package com.codev.ecommerce.payment;

import com.codev.ecommerce.notification.NotificationProducer;
import com.codev.ecommerce.notification.PaymentNotificationRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper mapper;
    private final NotificationProducer producer;

    public Integer createPayment(PaymentRequest request) {
        Payment payment = paymentRepository.save(mapper.toPayment(request));

        producer.sendPaymentNotification(new PaymentNotificationRequest(
                request.orderReference(),
                payment.getAmount(),
                payment.getPaymentMethod(),
                request.customer().firstname(),
                request.customer().lastname(),
                request.customer().email()
        ));

        return payment.getId();
    }
}
