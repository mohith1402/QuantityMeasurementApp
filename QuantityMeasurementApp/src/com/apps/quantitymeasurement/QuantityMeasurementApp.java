/*
 * UC7: Addition with Target Unit Specification
 *
 * @author Mohith
 * @version 7.0
 */

package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static class Length {
        public enum LengthUnit {
            FEET(12.0),
            INCHES(1.0),
            YARDS(36.0),
            CENTIMETERS(0.393701);

            public final double conversionFactor;

            LengthUnit(double conversionFactor) {
                this.conversionFactor = conversionFactor;
            }
        }

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

        public static double convert(double value, LengthUnit sourceUnit, LengthUnit targetUnit) {
            if (!Double.isFinite(value)) {
                throw new IllegalArgumentException("Value must be finite");
            }
            if (sourceUnit == null || targetUnit == null) {
                throw new IllegalArgumentException("Units cannot be null");
            }
            double inInches = value * sourceUnit.conversionFactor;
            return inInches / targetUnit.conversionFactor;
        }

        public Length add(Length other) {
            if (other == null) {
                throw new IllegalArgumentException("Cannot add null length");
            }
            double otherConverted = convert(other.value, other.unit, this.unit);
            return new Length(this.value + otherConverted, this.unit);
        }

        public Length add(Length other, LengthUnit targetUnit) {
            if (other == null || targetUnit == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            double thisConverted = convert(this.value, this.unit, targetUnit);
            double otherConverted = convert(other.value, other.unit, targetUnit);
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

            double thisInInches = this.value * this.unit.conversionFactor;
            double otherInInches = length.value * length.unit.conversionFactor;

            return Math.abs(thisInInches - otherInInches) <= 0.01;
        }
    }

    public static void main(String[] args) {
        Length foot = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);

        Length sumInYards = foot.add(inches, Length.LengthUnit.YARDS);
        System.out.println("1 Foot + 12 Inches in Yards = " + sumInYards.getValue() + " " + sumInYards.getUnit());

        Length inch1 = new Length(2.0, Length.LengthUnit.INCHES);
        Length cm1 = new Length(2.54, Length.LengthUnit.CENTIMETERS);

        Length sumInInches = inch1.add(cm1, Length.LengthUnit.INCHES);
        System.out.println("2 Inches + 2.54 Centimeters in Inches = " + sumInInches.getValue() + " " + sumInInches.getUnit());
    }
}