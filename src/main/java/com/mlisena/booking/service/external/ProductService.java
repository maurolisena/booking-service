package com.mlisena.booking.service.external;

import com.mlisena.booking.client.product.Product;
import com.mlisena.booking.client.product.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductClient productClient;

    public Product getProductById(String id) {
        return productClient.getProductById(id);
    }
}
