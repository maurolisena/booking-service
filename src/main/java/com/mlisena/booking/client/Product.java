package com.mlisena.booking.client;

import lombok.Data;

@Data
public class Product {

    private String id;
    private String name;
    private String code;
    private String description;
    private double price;
    private int stock;
    private String categoryId;
}
