package com.mlisena.booking.exception.booking;

import com.mlisena.booking.exception.common.NotFoundException;

import java.io.Serial;

public class BookingNotFoundException extends NotFoundException {

    @Serial
    private static final long serialVersionUID = 1L;

    public BookingNotFoundException(String message) {
        super(message);
    }
}
