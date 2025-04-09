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
        return BookingResponse.builder()
                .id(booking.getId())
                .userId(booking.getUserId())
                .product(product)
                .bookingDate(booking.getBookingDate())
                .quantity(booking.getQuantity())
                .status(booking.getStatus())
                .build();
    }

    public static Booking toEntity(BookingRequest bookingRequest) {
        return Booking.builder()
                .userId(bookingRequest.getUserId())
                .productId(bookingRequest.getProductId())
                .bookingDate(bookingRequest.getBookingDate())
                .quantity(bookingRequest.getQuantity())
                .status(bookingRequest.getStatus())
                .build();
    }

    public static Booking updateEntity(Booking booking, BookingRequest bookingRequest) {
        booking.setUserId(bookingRequest.getUserId());
        booking.setProductId(bookingRequest.getProductId());
        booking.setBookingDate(bookingRequest.getBookingDate());
        booking.setQuantity(bookingRequest.getQuantity());
        booking.setStatus(bookingRequest.getStatus());
        return booking;
    }
}