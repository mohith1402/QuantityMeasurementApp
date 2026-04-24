/*
 * UC1: Feet measurement equality
 *
 * @author Mohith
 * @version 1.0
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

    public static void main(String[] args) {
        System.out.println("UC1: Feet measurement equality\n");

        Feet feet1 = new Feet(10.0);
        Feet feet2 = new Feet(10.0);
        Feet feet3 = new Feet(12.0);

        System.out.println("feet1 (10.0) equals feet2 (10.0): " + feet1.equals(feet2));
        System.out.println("feet1 (10.0) equals feet3 (12.0): " + feet1.equals(feet3));
    }
}