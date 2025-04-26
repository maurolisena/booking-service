package com.mlisena.booking.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record BookingRequest(
        @NotNull(message = "Product ID cannot be null") String productId,
        String bookingDate,
        @Positive(message = "Quantity must be greater than 0") int quantity,
        String status
) { }
