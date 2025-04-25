package com.mlisena.booking.client.product;

public record Product(
        String id,
        String name,
        String code,
        String description,
        double price,
        int stock,
        String categoryId
) { }
