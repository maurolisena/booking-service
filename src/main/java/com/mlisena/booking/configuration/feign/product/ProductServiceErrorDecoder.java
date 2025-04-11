package com.mlisena.booking.configuration.feign.product;
import com.mlisena.booking.exception.product.ProductNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class ProductServiceErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        return switch (response.status()) {
            case 400 -> new ProductNotFoundException("Product not found (from Feign): " + response.reason());
            case 401 -> new IllegalAccessException("Unauthorized access to Product Service: " + response.reason());
            case 403 -> new SecurityException("Product service Forbidden resource: " + response.reason());
            case 404 -> new IllegalStateException("Product service resource Not Found: " + response.reason());
            case 500 -> new RuntimeException("Product service Internal Server Error: " + response.body().toString());
            default -> defaultErrorDecoder.decode(s, response);
        };
    }
}
