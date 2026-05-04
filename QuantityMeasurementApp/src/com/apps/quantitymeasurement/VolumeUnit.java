package com.apps.quantitymeasurement;

public enum VolumeUnit implements IMeasurable<VolumeUnit> {
    LITRE(1.0),
    MILLILITRE(0.001),
    GALLON(3.78541);

    private final double conversionFactor;

    VolumeUnit(double conversionFactor) {
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