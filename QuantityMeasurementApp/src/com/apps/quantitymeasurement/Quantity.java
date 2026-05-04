package com.apps.quantitymeasurement;

public class Quantity<U extends Enum<U> & IMeasurable<U>> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        if (unit == null || !Double.isFinite(value)) {
            throw new IllegalArgumentException();
        }
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return this.value;
    }

    public U getUnit() {
        return this.unit;
    }

    public Quantity<U> convertTo(U targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException();
        }
        double baseValue = this.unit.convertToBaseUnit(this.value);
        double convertedValue = targetUnit.convertFromBaseUnit(baseValue);
        return new Quantity<>(convertedValue, targetUnit);
    }

    public Quantity<U> add(Quantity<U> other) {
        if (other == null) {
            throw new IllegalArgumentException();
        }
        Quantity<U> otherConverted = other.convertTo(this.unit);
        return new Quantity<>(this.value + otherConverted.getValue(), this.unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        if (other == null || targetUnit == null) {
            throw new IllegalArgumentException();
        }
        Quantity<U> thisConverted = this.convertTo(targetUnit);
        Quantity<U> otherConverted = other.convertTo(targetUnit);
        return new Quantity<>(thisConverted.getValue() + otherConverted.getValue(), targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Quantity<?> other = (Quantity<?>) obj;

        if (!this.unit.getClass().equals(other.unit.getClass())) {
            return false;
        }

        @SuppressWarnings("unchecked")
        Quantity<U> typedOther = (Quantity<U>) other;

        double thisBase = this.unit.convertToBaseUnit(this.value);
        double otherBase = typedOther.unit.convertToBaseUnit(typedOther.value);

        return Math.abs(thisBase - otherBase) <= 0.01;
    }
}