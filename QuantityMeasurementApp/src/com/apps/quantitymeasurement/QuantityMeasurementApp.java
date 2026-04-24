/*
 * UC6: Addition of Two Length Units
 *
 * @author Mohith
 * @version 6.0
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
        Length inch1 = new Length(2.0, Length.LengthUnit.INCHES);
        Length inch2 = new Length(2.0, Length.LengthUnit.INCHES);
        Length sum1 = inch1.add(inch2);
        System.out.println("2 Inches + 2 Inches = " + sum1.getValue() + " " + sum1.getUnit());

        Length foot1 = new Length(1.0, Length.LengthUnit.FEET);
        Length inch3 = new Length(2.0, Length.LengthUnit.INCHES);
        Length sum2 = inch3.add(foot1);
        System.out.println("2 Inches + 1 Foot = " + sum2.getValue() + " " + sum2.getUnit());

        Length foot2 = new Length(1.0, Length.LengthUnit.FEET);
        Length foot3 = new Length(1.0, Length.LengthUnit.FEET);
        Length sum3 = foot2.add(foot3);
        System.out.println("1 Foot + 1 Foot = " + sum3.getValue() + " " + sum3.getUnit());

        Length inch4 = new Length(2.0, Length.LengthUnit.INCHES);
        Length cm1 = new Length(2.54, Length.LengthUnit.CENTIMETERS);
        Length sum4 = inch4.add(cm1);
        System.out.println("2 Inches + 2.54 Centimeters = " + sum4.getValue() + " " + sum4.getUnit());
    }
}