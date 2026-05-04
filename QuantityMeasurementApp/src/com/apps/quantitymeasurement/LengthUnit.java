package com.apps.quantitymeasurement;

public enum LengthUnit implements IMeasurable<LengthUnit> {
    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),
    CENTIMETERS(0.393701);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double getConversionFactor() {
        return this.conversionFactor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException();
        }
        return value * this.conversionFactor;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        if (!Double.isFinite(baseValue)) {
            throw new IllegalArgumentException();
        }
        return baseValue / this.conversionFactor;
    }
}