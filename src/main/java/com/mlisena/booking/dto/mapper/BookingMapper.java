package com.mlisena.booking.dto.mapper;

import com.mlisena.booking.client.Product;
import com.mlisena.booking.dto.request.BookingRequest;
import com.mlisena.booking.dto.response.BookingResponse;
import com.mlisena.booking.entity.Booking;


public class BookingMapper {

    private BookingMapper() {
        // Private constructor to prevent instantiation
    }

    public static BookingResponse toResponse(Booking booking, Product product) {
        return new BookingResponse(
                booking.getId(),
                booking.getUserId(),
                product,
                booking.getBookingDate(),
                booking.getQuantity(),
                booking.getStatus()
        );
    }

    public static Booking toEntity(BookingRequest bookingRequest) {
        return Booking.builder()
                .userId(bookingRequest.userId())
                .productId(bookingRequest.productId())
                .bookingDate(bookingRequest.bookingDate())
                .quantity(bookingRequest.quantity())
                .status(bookingRequest.status())
                .build();
    }

    public static Booking updateEntity(Booking booking, BookingRequest bookingRequest) {
        booking.setUserId(bookingRequest.userId());
        booking.setProductId(bookingRequest.productId());
        booking.setBookingDate(bookingRequest.bookingDate());
        booking.setQuantity(bookingRequest.quantity());
        booking.setStatus(bookingRequest.status());
        return booking;
    }
}