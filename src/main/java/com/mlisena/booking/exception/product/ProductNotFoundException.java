package com.mlisena.booking.exception.product;

import com.mlisena.booking.exception.common.NotFoundException;

public class ProductNotFoundException extends NotFoundException {

    private static final long serialVersionUID = 1L;

    public ProductNotFoundException(String message) {
        super(message);
    }
}