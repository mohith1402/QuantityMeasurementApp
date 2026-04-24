/*
 * UC9: Weight Measurement Equality, Conversion, and Addition (Kilogram, Gram, Pound)
 *
 * @author Mohith
 * @version 9.0
 */

package com.apps.quantitymeasurement;

public class QuantityWeight {

    private final double value;
    private final WeightUnit unit;

    public QuantityWeight(double value, WeightUnit unit) {
        if (unit == null || !Double.isFinite(value)) {
            throw new IllegalArgumentException();
        }
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return this.value;
    }

    public WeightUnit getUnit() {
        return this.unit;
    }

    public QuantityWeight convertTo(WeightUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException();
        }
        double convertedValue = this.unit.convert(this.value, targetUnit);
        return new QuantityWeight(convertedValue, targetUnit);
    }

    public QuantityWeight add(QuantityWeight other) {
        if (other == null) {
            throw new IllegalArgumentException();
        }
        double otherConverted = other.unit.convert(other.value, this.unit);
        return new QuantityWeight(this.value + otherConverted, this.unit);
    }

    public QuantityWeight add(QuantityWeight other, WeightUnit targetUnit) {
        if (other == null || targetUnit == null) {
            throw new IllegalArgumentException();
        }
        double thisConverted = this.unit.convert(this.value, targetUnit);
        double otherConverted = other.unit.convert(other.value, targetUnit);
        return new QuantityWeight(thisConverted + otherConverted, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        QuantityWeight other = (QuantityWeight) obj;

        double thisInKg = this.unit.convertToBase(this.value);
        double otherInKg = other.unit.convertToBase(other.value);

        return Math.abs(thisInKg - otherInKg) <= 0.01;
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}