package com.apps.quantitymeasurement;

public enum LengthUnit {
    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),
    CENTIMETERS(0.393701);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
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

    public double convert(double value, LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException();
        }
        double baseValue = this.convertToBase(value);
        return targetUnit.convertFromBase(baseValue);
    }
}
