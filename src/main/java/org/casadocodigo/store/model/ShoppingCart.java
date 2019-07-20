package org.casadocodigo.store.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
@Scope(WebApplicationContext.SCOPE_SESSION)
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
