package com.mlisena.booking.service.external;

import com.mlisena.booking.client.inventory.InventoryClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryClient inventoryClient;

    public boolean isInStock(String skuCode, Integer quantity) {
        return inventoryClient.isInStock(skuCode, quantity);
    }
}
