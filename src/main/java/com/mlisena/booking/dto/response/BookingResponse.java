package com.mlisena.booking.dto.response;

import com.mlisena.booking.client.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class BookingResponse {

    private Long id;
    private String userId;
    private Product product;
    private String bookingDate;
    private int quantity;
    private String status;
}
