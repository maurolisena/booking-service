package com.mlisena.booking.dto.response;

import com.mlisena.booking.client.Product;

public record BookingResponse (
        Long id,
        String userId,
        Product product,
        String bookingDate,
        int quantity,
        String status
){ }
