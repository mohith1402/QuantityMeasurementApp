package com.apps.quantitymeasurement;

public enum WeightUnit {
    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double conversionFactor;

    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double convertToBase(double value) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException();
        }
        return value * this.conversionFactor;
    }

    public double convertFromBase(double baseValue) {
        if (!Double.isFinite(baseValue)) {
            throw new IllegalArgumentException();
        }
        return baseValue / this.conversionFactor;
    }

    public double convert(double value, WeightUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException();
        }
        double baseValue = this.convertToBase(value);
        return targetUnit.convertFromBase(baseValue);
    }
}