package com.mlisena.booking.service;

import com.mlisena.booking.client.product.Product;
import com.mlisena.booking.dto.mapper.BookingMapper;
import com.mlisena.booking.dto.request.BookingRequest;
import com.mlisena.booking.dto.response.BookingResponse;
import com.mlisena.booking.entity.Booking;
import com.mlisena.booking.exception.booking.BookingNotFoundException;
import com.mlisena.booking.repository.BookingRepository;
import com.mlisena.booking.service.external.InventoryService;
import com.mlisena.booking.service.external.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final ProductService productService;
    private final InventoryService inventoryService;

    public void createBooking(BookingRequest bookingRequest) {
        Product product = productService.getProductById(bookingRequest.productId());

        boolean isAvailable = inventoryService.isInStock(product.code(), bookingRequest.quantity());
        if (!isAvailable) throw new IllegalArgumentException("Product is not available in stock");

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
        return BookingMapper.toResponse(booking, product);
    }
}
