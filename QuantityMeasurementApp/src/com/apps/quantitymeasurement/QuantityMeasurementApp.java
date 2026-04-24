/*
 * UC2: Feet and Inches measurement equality
 *
 * @author Mohith
 * @version 2.0
 */

package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Feet feet = (Feet) obj;
            return Double.compare(feet.value, this.value) == 0;
        }
    }

    public static class Inches {
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Inches inches = (Inches) obj;
            return Double.compare(inches.value, this.value) == 0;
        }
    }

    public static boolean compareFeet(double val1, double val2) {
        Feet feet1 = new Feet(val1);
        Feet feet2 = new Feet(val2);
        return feet1.equals(feet2);
    }

    public static boolean compareInches(double val1, double val2) {
        Inches inches1 = new Inches(val1);
        Inches inches2 = new Inches(val2);
        return inches1.equals(inches2);
    }

    public static void main(String[] args) {
        System.out.println("Feet Equality (10.0, 10.0): " + compareFeet(10.0, 10.0));
        System.out.println("Feet Equality (10.0, 12.0): " + compareFeet(10.0, 12.0));

        System.out.println("Inches Equality (5.0, 5.0): " + compareInches(5.0, 5.0));
        System.out.println("Inches Equality (5.0, 7.0): " + compareInches(5.0, 7.0));
    }
}