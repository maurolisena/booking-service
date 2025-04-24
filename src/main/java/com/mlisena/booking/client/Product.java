package com.mlisena.booking.client;

public record Product(
        String id,
        String name,
        String code,
        String description,
        double price,
        int stock,
        String categoryId
) { }
