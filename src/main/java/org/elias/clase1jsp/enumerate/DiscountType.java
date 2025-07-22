package org.elias.clase1jsp.enumerate;

public enum DiscountType {
    ONE(0.04),
    TWO(0.065),
    THREE(0.09),
    FOUR(0.115);

    private final double value;

    DiscountType(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}