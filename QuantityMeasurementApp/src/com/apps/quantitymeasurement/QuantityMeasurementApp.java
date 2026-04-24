/*
 * UC3: Generic Quantity Class for DRY Principle
 *
 * @author Mohith
 * @version 3.0
 */

package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static class Length {
        public enum LengthUnit {
            FEET, INCHES
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
            return Double.compare(length.value, this.value) == 0 && this.unit == length.unit;
        }
    }

    public static void main(String[] args) {
        Length feet1 = new Length(10.0, Length.LengthUnit.FEET);
        Length feet2 = new Length(10.0, Length.LengthUnit.FEET);
        Length inches1 = new Length(5.0, Length.LengthUnit.INCHES);

        System.out.println("Feet Equality (10.0, 10.0): " + feet1.equals(feet2));
        System.out.println("Different Units Equality: " + feet1.equals(inches1));
    }
}