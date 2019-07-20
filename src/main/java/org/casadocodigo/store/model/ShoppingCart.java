package org.casadocodigo.store.model;

import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class ShoppingCart {

    private final Map<CartItem, Integer> items;

    public ShoppingCart() {
        items = new LinkedHashMap<>();
    }

    public void add(CartItem cartItem) {
        items.merge(cartItem, 1, Integer::sum);
    }

    public int getQuantity() {
        return items.values().stream()
            .reduce(0, Integer::sum);
    }
}
