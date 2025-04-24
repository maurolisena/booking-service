package com.mlisena.booking.service.external;

import com.mlisena.booking.client.Product;
import com.mlisena.booking.client.ProductClient;
import com.mlisena.booking.exception.product.ProductIllegalArgumentException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductClient productClient;

    public Product getProductById(String id) {
        return productClient.getProductById(id);
    }

    public void validateStock(Product product, int quantity) {
        if (product.stock() < quantity) {
            throw new ProductIllegalArgumentException("Insufficient stock for product: " + product.id());
        }
    }
}
