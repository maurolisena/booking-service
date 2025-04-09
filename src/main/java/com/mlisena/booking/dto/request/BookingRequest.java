package com.mlisena.booking.dto.request;

import lombok.Data;

@Data
public class BookingRequest {

    private String userId;
    private String productId;
    private String bookingDate;
    private int quantity;
    private String status;
}
