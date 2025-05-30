package com.mlisena.booking.exception.product;

import com.mlisena.booking.exception.common.IlegalArgumentException;

import java.io.Serial;

public class ProductIllegalArgumentException extends IlegalArgumentException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ProductIllegalArgumentException(String message) {
        super(message);
    }
}
