package com.mlisena.booking.dto.mapper;

import com.mlisena.booking.client.product.Product;
import com.mlisena.booking.dto.request.BookingRequest;
import com.mlisena.booking.dto.response.BookingResponse;
import com.mlisena.booking.entity.Booking;

import java.time.LocalDateTime;


public class BookingMapper {

    private BookingMapper() {
        // Private constructor to prevent instantiation
    }

    public static BookingResponse toResponse(Booking booking, Product product) {
        return new BookingResponse(
                booking.getId(),
                product,
                booking.getBookingDate(),
                booking.getQuantity(),
                booking.getStatus()
        );
    }

    public static Booking toEntity(BookingRequest bookingRequest) {
        return Booking.builder()
                .productId(bookingRequest.productId())
                .bookingDate(bookingRequest.bookingDate())
                .quantity(bookingRequest.quantity())
                .status(bookingRequest.status())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static void updateEntity(Booking booking, BookingRequest bookingRequest) {
        booking.setProductId(bookingRequest.productId());
        booking.setBookingDate(bookingRequest.bookingDate());
        booking.setQuantity(bookingRequest.quantity());
        booking.setStatus(bookingRequest.status());
        booking.setUpdatedAt(LocalDateTime.now());
    }
}