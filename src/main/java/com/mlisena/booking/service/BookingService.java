package com.mlisena.booking.service;

import com.mlisena.booking.client.Product;
import com.mlisena.booking.dto.mapper.BookingMapper;
import com.mlisena.booking.dto.request.BookingRequest;
import com.mlisena.booking.dto.response.BookingResponse;
import com.mlisena.booking.entity.Booking;
import com.mlisena.booking.exception.booking.BookingNotFoundException;
import com.mlisena.booking.repository.BookingRepository;
import com.mlisena.booking.service.external.ProductService;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final ProductService productService;

    public BookingService(
            BookingRepository bookingRepository,
            ProductService productService
    ) {
        this.bookingRepository = bookingRepository;
        this.productService = productService;
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
                .orElseThrow(() -> new BookingNotFoundException("Booking not found with id: " + id));

        Product product = productService.getProductById(booking.getProductId());
        productService.validateStock(product, booking.getQuantity());

        return BookingMapper.toResponse(booking, product);
    }
}
