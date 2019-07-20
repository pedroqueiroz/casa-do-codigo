package org.casadocodigo.store.model;

import java.util.Objects;

public class CartItem {
    private Product product;
    private PriceType priceType;

    public CartItem(Product product, PriceType priceType) {
        this.product = product;
        this.priceType = priceType;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public PriceType getPriceType() {
        return priceType;
    }

    public void setPriceType(PriceType priceType) {
        this.priceType = priceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return product.equals(cartItem.product) &&
            priceType == cartItem.priceType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, priceType);
    }
}
