package com.mlisena.booking.dto.response;

import com.mlisena.booking.client.product.Product;

public record BookingResponse (
        Long id,
        Product product,
        String bookingDate,
        int quantity,
        String status
){ }
