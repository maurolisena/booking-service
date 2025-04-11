package com.mlisena.booking.service.external;

import com.mlisena.booking.client.Product;
import com.mlisena.booking.client.ProductClient;
import com.mlisena.booking.exception.product.ProductIllegalArgumentException;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductClient productClient;

    public ProductService(ProductClient productClient) {
        this.productClient = productClient;
    }

    public Product getProductById(String id) {
        return productClient.getProductById(id);
    }

    public void validateStock(Product product, int quantity) {
        if (product.getStock() < quantity) {
            throw new ProductIllegalArgumentException("Insufficient stock for product: " + product.getId());
        }
    }
}
