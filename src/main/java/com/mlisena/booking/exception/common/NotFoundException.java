package com.mlisena.booking.exception.common;

import java.io.Serial;

public abstract class NotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    protected NotFoundException(String message) {
        super(message);
    }
}
