package com.mlisena.booking.configuration.feign.product;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ProductServiceFeignConfiguration {

    private ProductServiceFeignConfiguration(){
        // Private constructor to prevent instantiation
    }

    @Configuration
    public static class ProductServiceFeignConfig {

        @Bean
        public ErrorDecoder productServiceErrorDecoder() {
            return new ProductServiceErrorDecoder();
        }
    }
}
