package org.casadocodigo.store.model;

import java.math.BigDecimal;

public class Price {

    public PriceType getPriceType() {
        return priceType;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setPriceType(PriceType priceType) {
        this.priceType = priceType;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    private PriceType priceType;
    private BigDecimal value;
}
