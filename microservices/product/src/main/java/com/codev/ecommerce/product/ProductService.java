package com.codev.ecommerce.product;

import com.codev.ecommerce.exception.ProductPurchaseException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper mapper;
    public Integer createProduct(@Valid ProductRequest request) {
        Product product = productRepository.save(mapper.toProduct(request));
        return product.getId();
    }

    public List<ProductPurchaseResponse> purchaseProduct(List<ProductPurchaseRequest> request) {
        List<Integer> productIds = request.stream()
                .map(ProductPurchaseRequest::productId)
                .toList();

        List<Product> storedProducts = productRepository.findAllByIdInOrderById(productIds);

        if (storedProducts.size() != productIds.size()) {
            throw new ProductPurchaseException("Not all products found in the database");
        }

        List<ProductPurchaseRequest> storesRequest = request.stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::productId))
                .toList();

        List<ProductPurchaseResponse> purchasedProduct = new ArrayList<ProductPurchaseResponse>();
        for (int i = 0; i < storedProducts.size(); i++) {
            Product product = storedProducts.get(i);
            ProductPurchaseRequest productRequest = storesRequest.get(i);

            if (productRequest.quantity() > product.getAvailableQuantity()) {
                throw new ProductPurchaseException(format("Not enough stock for product with ID:: %s", product.getId()));
            }

            product.setAvailableQuantity(product.getAvailableQuantity() - productRequest.quantity());
            productRepository.save(product);

            purchasedProduct.add(mapper.toProductPurchaseResponse(product, productRequest.quantity())  );
        }
        return purchasedProduct;
    }

    public ProductResponse findById(Integer productId) {
        return productRepository.findById(productId)
                .map(mapper::toProductResponse)
               .orElseThrow( () -> new EntityNotFoundException(format("No product found with the provided ID:: %s", productId) ));
    }

    public List<ProductResponse> findAll() {
        return productRepository.findAll()
                .stream()
               .map(mapper::toProductResponse)
                .collect(Collectors.toList());
    }
}
