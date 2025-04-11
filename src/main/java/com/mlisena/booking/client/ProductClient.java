package com.mlisena.booking.client;

import com.mlisena.booking.configuration.feign.product.ProductServiceFeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
    name = "PRODUCT-SERVICE",
    configuration = ProductServiceFeignConfiguration.class
)
public interface ProductClient {

    @GetMapping("/api/products/{id}")
    Product getProductById(@PathVariable("id") String id);
}
