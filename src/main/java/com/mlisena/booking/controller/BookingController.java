package com.mlisena.booking.controller;

import com.mlisena.booking.dto.request.BookingRequest;
import com.mlisena.booking.dto.response.BookingResponse;
import com.mlisena.booking.service.BookingService;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/bookings")
@RefreshScope
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<BookingResponse> createBooking(@RequestBody BookingRequest request) {
        bookingService.createBooking(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingResponse> getBookingById(@PathVariable Long id) {
        BookingResponse bookingResponse = bookingService.getBooking(id);
        return ResponseEntity.ok(bookingResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBooking(
        @PathVariable Long id,
        @RequestBody BookingRequest bookingRequest
    ) {
        bookingService.updateBooking(id, bookingRequest);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
