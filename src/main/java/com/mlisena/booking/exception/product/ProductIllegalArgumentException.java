package com.mlisena.booking.exception.product;

import java.io.Serial;

public class ProductIllegalArgumentException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ProductIllegalArgumentException(String message) {
        super(message);
    }
}
