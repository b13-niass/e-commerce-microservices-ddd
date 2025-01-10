package com.codev.ecommerce.order;

import com.codev.ecommerce.customer.CustomerClient;
import com.codev.ecommerce.customer.CustomerResponse;
import com.codev.ecommerce.exception.BusinessException;
import com.codev.ecommerce.order.product.PurchaseRequest;
import com.codev.ecommerce.orderline.OrderLineRequest;
import com.codev.ecommerce.orderline.OrderLineService;
import com.codev.ecommerce.product.ProductClient;
import com.codev.ecommerce.product.PurchaseResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository repository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;

    public Integer createOrder(OrderRequest request) {
        // Utilisation d'OpenFeign "paradigme de programmation Déclarative" pour appeler le service client
        CustomerResponse customer = customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order :: No Customer exist with provided ID"));

        // Utilisation de RestTemplate "paradigme de programmation fonctionnelle" pour appeler le service client"
         List<PurchaseResponse> purchaseResponses = productClient.purchaseProduct(request.products());
         Order order = repository.save(mapper.toOrder(request));

         for (PurchaseRequest purchaseRequest: request.products()) {
            orderLineService.saveOrderLine(
              new OrderLineRequest(
                      null,
                      order.getId(),
                      purchaseRequest.productId(),
                      purchaseRequest.quantity()
              )
            );
         }
        return null;
    }
}
