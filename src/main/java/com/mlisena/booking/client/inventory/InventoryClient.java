package com.mlisena.booking.client.inventory;

import com.mlisena.booking.configuration.feign.inventory.InventoryServiceFeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "INVENTORY-SERVICE",
        configuration = InventoryServiceFeignConfiguration.class
)
public interface InventoryClient {

    @GetMapping("/api/inventory")
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);
}
