/*
 * UC4: Extended Unit Support
 *
 * @author Mohith
 * @version 4.0
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
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(3.0, Length.LengthUnit.FEET);
        Length inch = new Length(36.0, Length.LengthUnit.INCHES);
        Length cm = new Length(2.54, Length.LengthUnit.CENTIMETERS);
        Length inch1 = new Length(1.0, Length.LengthUnit.INCHES);

        System.out.println("1 Yard equals 3 Feet: " + yard.equals(feet));
        System.out.println("1 Yard equals 36 Inches: " + yard.equals(inch));
        System.out.println("2.54 Centimeters equals 1 Inch: " + cm.equals(inch1));
    }
}