package com.codev.ecommerce.orderline;

import com.codev.ecommerce.order.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderLineMapper {

    public OrderLine toOrderLine(OrderLineRequest request) {
        if (request == null) {
            return null;
        }
        return OrderLine.builder()
                .id(request.id())
                .order(Order.builder().id(request.orderId()).build())
                .productId(request.productId())
                .quantity(request.quantity())
                .build();
    }
}
