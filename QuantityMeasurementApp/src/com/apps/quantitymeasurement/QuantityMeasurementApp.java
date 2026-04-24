/*
 * UC8: Refactoring Unit Enum to Standalone with Conversion Responsibility
 *
 * @author Mohith
 * @version 8.0
 */

package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {
        Length foot = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);

        Length sumInYards = foot.add(inches, LengthUnit.YARDS);
        System.out.println("1 Foot + 12 Inches in Yards = " + sumInYards.getValue() + " " + sumInYards.getUnit());

        Length inch1 = new Length(2.0, LengthUnit.INCHES);
        Length cm1 = new Length(2.54, LengthUnit.CENTIMETERS);

        Length sumInInches = inch1.add(cm1, LengthUnit.INCHES);
        System.out.println("2 Inches + 2.54 Centimeters in Inches = " + sumInInches.getValue() + " " + sumInInches.getUnit());

        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet = new Length(2.0, LengthUnit.FEET);

        Length sumInFeet = yard.add(feet, LengthUnit.FEET);
        System.out.println("1 Yard + 2 Feet in Feet = " + sumInFeet.getValue() + " " + sumInFeet.getUnit());
    }
}