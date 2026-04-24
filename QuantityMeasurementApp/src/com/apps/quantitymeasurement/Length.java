package com.apps.quantitymeasurement;

public class Length {

    private final double value;
    private final LengthUnit unit;

    public Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return this.value;
    }

    public LengthUnit getUnit() {
        return this.unit;
    }

    public Length add(Length other) {
        if (other == null) {
            throw new IllegalArgumentException();
        }
        double otherConverted = other.unit.convert(other.value, this.unit);
        return new Length(this.value + otherConverted, this.unit);
    }

    public Length add(Length other, LengthUnit targetUnit) {
        if (other == null || targetUnit == null) {
            throw new IllegalArgumentException();
        }
        double thisConverted = this.unit.convert(this.value, targetUnit);
        double otherConverted = other.unit.convert(other.value, targetUnit);
        return new Length(thisConverted + otherConverted, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Length length = (Length) obj;

        double thisInInches = this.unit.convertToBase(this.value);
        double otherInInches = length.unit.convertToBase(length.value);

        return Math.abs(thisInInches - otherInInches) <= 0.01;
    }
}
