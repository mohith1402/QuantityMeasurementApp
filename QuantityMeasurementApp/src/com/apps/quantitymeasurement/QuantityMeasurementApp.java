/*
 * UC5: Unit-to-Unit Conversion
 *
 * @author Mohith
 * @version 5.0
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
        System.out.println("2 Yards to Inches: " + Length.convert(2.0, Length.LengthUnit.YARDS, Length.LengthUnit.INCHES));
        System.out.println("36 Inches to Yards: " + Length.convert(36.0, Length.LengthUnit.INCHES, Length.LengthUnit.YARDS));
        System.out.println("1 Yard to Feet: " + Length.convert(1.0, Length.LengthUnit.YARDS, Length.LengthUnit.FEET));
        System.out.println("2.54 Centimeters to Inches: " + Length.convert(2.54, Length.LengthUnit.CENTIMETERS, Length.LengthUnit.INCHES));
    }
}