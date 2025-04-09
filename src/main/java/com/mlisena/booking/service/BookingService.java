package com.mlisena.booking.service;

import com.mlisena.booking.client.Product;
import com.mlisena.booking.client.ProductClient;
import com.mlisena.booking.dto.mapper.BookingMapper;
import com.mlisena.booking.dto.request.BookingRequest;
import com.mlisena.booking.dto.response.BookingResponse;
import com.mlisena.booking.entity.Booking;
import com.mlisena.booking.repository.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final ProductClient productClient;

    public BookingService(
        BookingRepository bookingRepository,
        ProductClient productClient
    ) {
        this.bookingRepository = bookingRepository;
        this.productClient = productClient;
    }

    public void createBooking(BookingRequest bookingRequest) {
        Booking booking = BookingMapper.toEntity(bookingRequest);
        bookingRepository.save(booking);
    }

    public void updateBooking(Long bookingId, BookingRequest bookingRequest) {
        Booking booking = bookingRepository.findById(bookingId).orElse(null);

        if (booking != null) {
            BookingMapper.updateEntity(booking, bookingRequest);
            bookingRepository.save(booking);
        }
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    public BookingResponse getBooking(Long id) {

        Booking booking = bookingRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));

        Product product = productClient.getProductById(booking.getProductId());

        return BookingMapper.toResponse(booking, product);
    }
}
